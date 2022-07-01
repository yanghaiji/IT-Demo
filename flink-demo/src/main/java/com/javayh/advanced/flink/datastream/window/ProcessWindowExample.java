package com.javayh.advanced.flink.datastream.window;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.util.GenerateStream;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.sql.Timestamp;
import java.util.HashSet;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.window → ProcessWindowExample
 * @since 2022-06-26
 */
public class ProcessWindowExample {
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
                .window(TumblingEventTimeWindows.of(Time.seconds(10)))
                .process(new ProcessWindowFunction<Order, String, Boolean, TimeWindow>() {
                    @Override
                    public void process(Boolean aBoolean, Context context, Iterable<Order> iterable, Collector<String> collector) throws Exception {
                        HashSet<String> userSet = new HashSet<>();
                        // 遍历所有数据，放到 Set 里去重
                        for (Order event : iterable) {
                            userSet.add(event.name);
                        }
                        // 结合窗口信息，包装输出内容
                        Long start = context.window().getStart();
                        Long end = context.window().getEnd();
                        collector.collect(" 窗 口 : " + new Timestamp(start) + " ~ " + new Timestamp(end) + " 的独立访客数量是：" + userSet.size());
                    }
                })
                .print("ProcessWindowExample>>>>>.");

        env.execute();

    }
}
