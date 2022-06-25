package com.javayh.advanced.flink.datastream.watermarks;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.util.GenerateStream;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStreamSource;

import java.time.Duration;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.watermarks → WatermarkExample
 * @since 2022-06-21
 */
public class WatermarkExample {

    public static void main(String[] args) {
        DataStreamSource<Order> env = GenerateStream.generateOrder();

        // 插入水位线的逻辑
        env.assignTimestampsAndWatermarks(
                // 针对乱序流插入水位线，延迟时间设置为 5s
                WatermarkStrategy
                        .<Order>forBoundedOutOfOrderness(Duration.ofSeconds(5))
                        .withTimestampAssigner(new SerializableTimestampAssigner<Order>() {
                            // 抽取时间戳的逻辑
                            @Override
                            public long extractTimestamp(Order element, long recordTimestamp) {
                                return element.time;
                            }
                        })
        ).print("WatermarkExample ===>");


        GenerateStream.execute();
    }


}
