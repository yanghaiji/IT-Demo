package com.javayh.advanced.flink.datastream.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

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
public class Api2Example {

    public static void main(String[] args) throws Exception {


        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> streamSource = env.socketTextStream("127.0.0.1", 8989);
        //将输入的数据 转换成元组类型
        streamSource.map(new MapFunction<String,  Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String s) throws Exception {
                return Tuple2.of(s, 1);
            }
        })
                //进行 数据过滤
                .filter(tu -> "haiji".equals(tu.f0) || "dylan".equals(tu.f0))
                .flatMap(new FlatMapFunction<Tuple2<String, Integer>, Tuple2<String, Integer>>() {
                    @Override
                    public void flatMap(Tuple2<String, Integer> t1, Collector<Tuple2<String, Integer>> collector) throws Exception {
                        if("haiji".equals(t1.f0)){
                            collector.collect(t1);
                        }
                        if("dylan".equals(t1.f0)){
                            collector.collect(t1);
                        }
                    }
                })
                //根据 key进行分组
                .keyBy(r-> r.f0)
                // 进行加和操作
                .sum(1)
                //.min(1)
//                .keyBy(r-> r.f0)
//                .maxBy("f0")
                .print("Api2 ===>");
        env.execute();

    }
}
