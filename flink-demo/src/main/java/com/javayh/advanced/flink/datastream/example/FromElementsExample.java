package com.javayh.advanced.flink.datastream.example;

import com.javayh.advanced.flink.entity.Person;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
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
 * @className advanced-demo → com.javayh.advanced.flink.datastream → Example
 * @since 2022-06-12
 */
public class FromElementsExample {

    public static void main(String[] args) throws Exception {
        // 获取环境信息
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 获取数据流
//        DataStream<Person> dataStreamSource = env.fromElements(
//                new Person("Fred", 35),
//                new Person("Wilma", 35),
//                new Person("Pebbles", 2)
//        );
        // 上下两种方式都可以
        List<Person> people = new ArrayList<>();
        people.add(new Person("Fred", 35));
        people.add(new Person("Wilma", 35));
        people.add(new Person("Pebbles", 2));
        DataStreamSource<Person> dataStreamSource = env.fromCollection(people);
        // 进行 filter
        DataStream<Person> adults = dataStreamSource.filter(((FilterFunction<Person>) person -> person.age >= 18));


        adults.print("Example===>");
        // 提交执行
        env.execute();
    }
}
