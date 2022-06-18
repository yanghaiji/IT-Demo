package com.javayh.advanced.flink.datastream.example;

import com.javayh.advanced.flink.wc.BatchWordCount;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * <p>
 * 文件读取输出流
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream → ReadTextFileExample
 * @since 2022-06-15
 */
public class ReadTextFileExample {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> streamSource = env.readTextFile("");

        SingleOutputStreamOperator<Tuple2<String, Integer>> singleOutputStreamOperator =
                streamSource.flatMap((FlatMapFunction<String, Tuple2<String, Integer>>) (vale, collector) -> {
                    String[] split = vale.split(",");
                    for (String var : split) {
                        collector.collect(new Tuple2<>(var,1));
                    }
                });

        singleOutputStreamOperator.print();
        env.execute("ReadTextFile");
    }

}
