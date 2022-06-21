package com.javayh.advanced.flink.datastream.example;

import com.javayh.advanced.flink.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.example → RichFlatMapFunctionExample
 * @since 2022-06-19
 */
@Slf4j
public class RichFlatMapFunctionExample {

    public static void main(String[] args) throws Exception {
        // 获取环境信息
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 获取数据流
        // 上下两种方式都可以
        List<Person> people = new ArrayList<>();
        people.add(new Person("Fred", 35));
        people.add(new Person("Wilma", 35));
        people.add(new Person("Pebbles", 2));
        DataStreamSource<Person> dataStreamSource = env.fromCollection(people);
        dataStreamSource.flatMap(new MyRichFlatMapFunction()).print("MyRichFlatMapFunction===>");

        env.execute();
    }

    /**
     * 可以在 open 方法 进行对外数据的链接操作
     * <p>
     * RichMapFunction 的用法类似
     */
    public static class MyRichFlatMapFunction extends RichFlatMapFunction<Person, Integer> {


        @Override
        public void open(Configuration parameters) throws Exception {
            // 获取运行上下文
            RuntimeContext runtimeContext = getRuntimeContext();
            System.out.println(runtimeContext.getTaskName() + "资源打开");
        }

        @Override
        public void close() throws Exception {
            // 获取运行上下文
            RuntimeContext runtimeContext = getRuntimeContext();
            System.out.println(runtimeContext.getTaskName() + "资源关闭");
        }

        @Override
        public void flatMap(Person person, Collector<Integer> collector) throws Exception {

            collector.collect(person.age);
        }
    }
}
