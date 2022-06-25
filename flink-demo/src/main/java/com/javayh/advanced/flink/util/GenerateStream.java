package com.javayh.advanced.flink.util;

import com.javayh.advanced.flink.entity.Order;
import com.javayh.advanced.flink.entity.Person;
import lombok.SneakyThrows;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
public class GenerateStream implements SourceFunction<Order> {

    // 声明一个布尔变量，作为控制数据生成的标识位
    private Boolean running = true;

    @Override
    public void run(SourceContext<Order> ctx) throws Exception {
        Random random = new Random();    // 在指定的数据集中随机选取数据
        String[] users = {"Mary", "Alice", "Bob", "Cary"};
        Integer[] urls = {28, 45, 30, 28, 33};

        while (running) {
            ctx.collect(new Order(
                    users[random.nextInt(users.length)],
                    urls[random.nextInt(urls.length)],
                    Calendar.getInstance().getTimeInMillis()
            ));
            // 隔1秒生成一个点击事件，方便观测
            TimeUnit.SECONDS.sleep(1);
        }
    }
    @Override
    public void cancel() {
        running = false;
    }

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
