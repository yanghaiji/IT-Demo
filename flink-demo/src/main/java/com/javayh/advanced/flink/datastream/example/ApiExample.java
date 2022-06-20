package com.javayh.advanced.flink.datastream.example;

import com.javayh.advanced.flink.entity.Person;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

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
public class ApiExample {

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
                // 按照如数的字符串进行分流
                .keyBy(r -> r.f0)
                // 相关的数据 计数进行累加
                .reduce(new ReduceFunction<Tuple2<String, Integer>>() {
                    @Override
                    public Tuple2<String, Integer> reduce(Tuple2<String, Integer> t1, Tuple2<String, Integer> t2) throws Exception {
                        return Tuple2.of(t1.f0, t1.f1 + t2.f1);
                    }
                })
                // 未每条数据分配相同的key ，在次聚合，发送到同一个流中
                .keyBy(r -> true)
                // 选出最大的一个
                .reduce(new ReduceFunction<Tuple2<String, Integer>>() {
                    @Override
                    public Tuple2<String, Integer> reduce(Tuple2<String, Integer> t1, Tuple2<String, Integer> t2) throws Exception {
                        return t1.f1 > t2.f1 ? t1 : t2;
                    }
                }).print("Api ===> ");
        env.execute();

    }
}
