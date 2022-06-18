package com.javayh.advanced.flink.datastream.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.example → SocketExample
 * @since 2022-06-15
 */
public class SocketExample {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> streamSource = env.socketTextStream("127.0.0.1", 8989);
        // 数据转换
        SingleOutputStreamOperator<Tuple2<String, Integer>> map = streamSource.flatMap((FlatMapFunction<String, String>) (s, collector) -> {
           /* String[] split = s.split(",");
            for (String var : split) {
                collector.collect(var);
            }*/
            Arrays.asList(s.split(",")).forEach(collector::collect);
        }).returns(Types.STRING).map(o -> Tuple2.of(o, 1)).returns(Types.TUPLE(Types.STRING,Types.INT));
        // 分组 求和
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = map.keyBy(t -> t.f0).sum(1);
        sum.print();

        env.execute();
    }

}
