package com.javayh.advanced.flink.table;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.entity.PageEvent;
import com.javayh.advanced.flink.util.GenerateStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2022-06-29
 */
public class TableExample {

    public static void main(String[] args) throws Exception {
        // 获取流执行环境
        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        // 读取数据源
        SingleOutputStreamOperator<PageEvent> eventStream = env
                .fromElements(
                        new PageEvent("Alice", "./home", 1000L),
                        new PageEvent("Bob", "./cart", 1000L),
                        new PageEvent("Alice", "./prod?id=1", 5 * 1000L),
                        new PageEvent("Cary", "./home", 60 * 1000L),
                        new PageEvent("Bob", "./prod?id=3", 90 * 1000L),
                        new PageEvent("Alice", "./prod?id=7", 105 * 1000L)
                );
        // 获取表环境
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        // 将数据流转换成表
        Table eventTable = tableEnv.fromDataStream(eventStream);
        // 用执行 SQL 的方式提取数据
        Table visitTable = tableEnv.sqlQuery("select name,url from " + eventTable);
        // 将表转换成数据流，打印输出
        tableEnv.toDataStream(visitTable).print();
        // 执行程序
        env.execute();


    }
}
