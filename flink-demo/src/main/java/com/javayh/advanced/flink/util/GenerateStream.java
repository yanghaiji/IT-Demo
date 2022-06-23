package com.javayh.advanced.flink.util;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.entity.Person;
import lombok.SneakyThrows;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.util → GeneratePonserStream
 * @since 2022-06-20
 */
public class GenerateStream {

    final static StreamExecutionEnvironment ENV = StreamExecutionEnvironment.getExecutionEnvironment();


    public static DataStreamSource<Person> generatePerson() {
        // 上下两种方式都可以
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            people.add(new Person(String.valueOf(System.currentTimeMillis()), 20 + i));
        }
        return ENV.fromCollection(people);
    }


    public static DataStreamSource<Order> generateOrder() {

        Random random = new Random(50000);
        List<Order> people = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            people.add(new Order(String.valueOf(System.currentTimeMillis()), 20 + i, random.nextLong()));
        }
        return ENV.fromCollection(people);
    }


    @SneakyThrows
    public static void execute() {
        ENV.execute();
    }


}
