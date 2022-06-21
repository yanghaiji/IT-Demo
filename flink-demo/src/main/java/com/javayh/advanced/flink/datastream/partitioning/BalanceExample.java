package com.javayh.advanced.flink.datastream.partitioning;

import com.javayh.advanced.flink.entity.Person;
import org.apache.flink.api.common.functions.Partitioner;
import org.apache.flink.api.java.functions.KeySelector;
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
 * @className advanced-demo → com.javayh.advanced.flink.datastream.partitioning → ShuffleExample
 * @since 2022-06-19
 */
public class BalanceExample {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // 上下两种方式都可以
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(String.valueOf(System.currentTimeMillis()), 20 + i));
        }
        DataStreamSource<Person> dataStreamSource = env.fromCollection(people);

        /**
         * 随机分区（shuffle）
         * 轮询分区（Round-Robin）
         * 重缩放分区（rescale）
         * 广播（broadcast）
         * 全局分区（global）
         * 当然我们还可以自定义分区策略
         */
        dataStreamSource.shuffle().print("shuffle").setParallelism(4);
        dataStreamSource.rebalance().print("Round-Robin").setParallelism(4);
        dataStreamSource.rescale().print("rescale").setParallelism(4);
        dataStreamSource.broadcast().print("broadcast").setParallelism(4);
        dataStreamSource.global().print("global").setParallelism(4);
        dataStreamSource.partitionCustom(new Partitioner<Integer>() {
            @Override
            public int partition(Integer key, int i) {
                return key % 2;
            }
        }, new KeySelector<Person, Integer>() {
            @Override
            public Integer getKey(Person person) throws Exception {
                return person.age;
            }
        }).print("partitionCustom").setParallelism(4);

        env.execute("BalanceExample");
    }
}
