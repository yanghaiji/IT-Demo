package com.javayh.advanced.flink.datastream.window;

import com.javayh.advanced.flink.entity.PageEvent;
import com.javayh.advanced.flink.entity.UrlViewCount;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

import java.time.Duration;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.window → ProcessLateDataExample
 * @since 2022-06-26
 */

public class ProcessLateDataExample {

    /**
        haiji, ./home, 1000
        haiji, ./home, 2000
        haiji, ./home, 10000
        haiji, ./home, 9000
        haiji, ./cart, 12000
        haiji, ./prod?id=100, 15000
        haiji, ./home, 9000
        haiji, ./home, 8000
        haiji, ./prod?id=200, 70000
        haiji, ./home, 8000
        haiji, ./prod?id=300, 72000
        haiji, ./home, 8000
     */
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // 读取socket文本流
        SingleOutputStreamOperator<PageEvent> stream = env.socketTextStream("localhost", 7777)
                        .map(new MapFunction<String, PageEvent>() {
                            @Override
                            public PageEvent map(String value) throws Exception {
                                String[] fields = value.split(" ");
                                return new PageEvent(fields[0].trim(), fields[1].trim(), Long.valueOf(fields[2].trim()));
                            }
                        })
                        // 方式一：设置watermark延迟时间，2秒钟
                        .assignTimestampsAndWatermarks(WatermarkStrategy.<PageEvent>forBoundedOutOfOrderness(Duration.ofSeconds(2))
                                .withTimestampAssigner(new SerializableTimestampAssigner<PageEvent>() {
                                    @Override
                                    public long extractTimestamp(PageEvent element, long recordTimestamp) {
                                        return element.time;
                                    }
                                }));

        // 定义侧输出流标签
        OutputTag<PageEvent> outputTag = new OutputTag<PageEvent>("late"){};

        SingleOutputStreamOperator<UrlViewCount> result = stream.keyBy(data -> data.url)
                .window(TumblingEventTimeWindows.of(Time.seconds(10)))
                // 方式二：允许窗口处理迟到数据，设置1分钟的等待时间
                .allowedLateness(Time.minutes(1))
                // 方式三：将最后的迟到数据输出到侧输出流
                .sideOutputLateData(outputTag)
                .aggregate(new UrlViewCountAgg(), new UrlViewCountResult());

        result.print("result");
        result.getSideOutput(outputTag).print("late");

        // 为方便观察，可以将原始数据也输出
        stream.print("input");

        env.execute();
    }

    public static class UrlViewCountAgg implements AggregateFunction<PageEvent, Long, Long> {
        @Override
        public Long createAccumulator() {
            return 0L;
        }

        @Override
        public Long add(PageEvent value, Long accumulator) {
            return accumulator + 1;
        }

        @Override
        public Long getResult(Long accumulator) {
            return accumulator;
        }

        @Override
        public Long merge(Long a, Long b) {
            return null;
        }
    }

    public static class UrlViewCountResult extends ProcessWindowFunction<Long, UrlViewCount, String, TimeWindow> {

        @Override
        public void process(String url, Context context, Iterable<Long> elements, Collector<UrlViewCount> out) throws Exception {
            // 结合窗口信息，包装输出内容
            Long start = context.window().getStart();
            Long end = context.window().getEnd();
            out.collect(new UrlViewCount(url, elements.iterator().next(), start, end));
        }
    }
}

