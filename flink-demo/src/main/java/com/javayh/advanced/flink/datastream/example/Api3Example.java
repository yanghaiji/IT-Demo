package com.javayh.advanced.flink.datastream.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.example → ApiExample
 * @since 2022-06-19
 */
public class Api3Example {

    public static void main(String[] args) throws Exception {


        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> streamSource = env.socketTextStream("127.0.0.1", 8989);
        //将输入的数据 转换成元组类型
        streamSource.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {
                return Tuple2.of(s, 1);
            }
        })
                //根据 key进行分组
                .keyBy(r -> r.f0)
                // 进行加和操作
                .sum(1)
                // process 内可以获取上下文信息
                .process(new ProcessFunction<Tuple2<String, Integer>, String>() {
                    @Override
                    public void processElement(Tuple2<String, Integer> t1, Context context, Collector<String> collector) throws Exception {
                        Long timestamp = context.timestamp();
                        //context.output(new OutputTag<>());
                        collector.collect(t1.f0 +">>>>"+ t1.f1);
                    }
                })
                .print("Api3 ===>");
        env.execute();

    }
}
