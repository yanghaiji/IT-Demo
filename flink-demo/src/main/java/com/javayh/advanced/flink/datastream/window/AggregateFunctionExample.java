package com.javayh.advanced.flink.datastream.window;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.util.GenerateStream;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.util.HashSet;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.window → AggregateFunctionExample
 * @since 2022-06-24
 */
public class AggregateFunctionExample {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        SingleOutputStreamOperator<Order> stream = env.addSource(new
                GenerateStream())
                .assignTimestampsAndWatermarks(WatermarkStrategy.<Order>forMonotonousTimestamps()
                        .withTimestampAssigner(new SerializableTimestampAssigner<Order>() {
                            @Override
                            public long extractTimestamp(Order element, long recordTimestamp) {
                                return element.time;
                            }
                        }));
        // 所有数据设置相同的 key，发送到同一个分区统计 PV 和 UV，再相除
        stream.keyBy(data -> true)
                .window(SlidingEventTimeWindows.of(Time.seconds(10),
                        Time.seconds(2)))
                .aggregate(new AggregateFunction<Order, Tuple2<HashSet<String>, Long>, Double>() {
                    @Override
                    public Tuple2<HashSet<String>, Long> createAccumulator() {
                        // 创建累加器
                        return Tuple2.of(new HashSet<String>(), 0L);
                    }

                    @Override
                    public Tuple2<HashSet<String>, Long> add(Order order, Tuple2<HashSet<String>, Long> accumulator) {
                        // 属于本窗口的数据来一条累加一次，并返回累加器
                        accumulator.f0.add(order.name);
                        return Tuple2.of(accumulator.f0, accumulator.f1 + 1L);
                    }

                    @Override
                    public Double getResult(Tuple2<HashSet<String>, Long> accumulator) {
                        // 窗口闭合时，增量聚合结束，将计算结果发送到下游
                        return (double) accumulator.f1 / accumulator.f0.size();
                    }

                    @Override
                    public Tuple2<HashSet<String>, Long> merge(Tuple2<HashSet<String>, Long> hashSetLongTuple2, Tuple2<HashSet<String>, Long> acc1) {
                        return null;
                    }
                })
                .print("aggregate ====>");
        env.execute();

    }
}
