package com.javayh.advanced.flink.datastream.state;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.util.GenerateStream;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022-06-28
 */
public class ValueStateExample {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        SingleOutputStreamOperator<Order> stream = env.addSource(new GenerateStream())
                .assignTimestampsAndWatermarks(
                        WatermarkStrategy.<Order>forMonotonousTimestamps()
                                .withTimestampAssigner(new SerializableTimestampAssigner<Order>() {
                                    @Override
                                    public long extractTimestamp(Order order, long l) {
                                        return order.time;
                                    }
                                })
                );
        stream.print("input >>>");

        stream.keyBy(data->data.name)
                .process(new KeyedProcessFunction<String, Order, String>() {
                    // 定义两个状态，保存当前 pv 值，以及定时器时间戳
                    ValueState<Long> countState;
                    ValueState<Long> timerTsState;

                    @Override
                    public void open(Configuration parameters) throws Exception {
                        countState = getRuntimeContext().getState(new ValueStateDescriptor<Long>("count",Long.class));
                        timerTsState = getRuntimeContext().getState(new ValueStateDescriptor<Long>("time",Long.class));
                    }

                    @Override
                    public void processElement(Order order, Context context, Collector<String> collector) throws Exception {
                        Long count = countState.value();
                        if(Objects.isNull(count)){
                            countState.update(1L);
                        }else {
                            countState.update(count+1L);
                        }
                        // 注册一个定时器
                        if(Objects.isNull(timerTsState.value())){
                            long time = order.time + 10 * 1000L;
                            context.timerService().registerEventTimeTimer(time);
                            timerTsState.update(time);
                        }
                    }

                    @Override
                    public void onTimer(long timestamp, OnTimerContext ctx, Collector<String> out) throws Exception {
                        out.collect(ctx.getCurrentKey() + " onTimer: " + countState.value());
                        timerTsState.clear();
                    }
                })
                .print();

        env.execute();
    }
}
