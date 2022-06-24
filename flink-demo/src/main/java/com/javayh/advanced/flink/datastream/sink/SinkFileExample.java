package com.javayh.advanced.flink.datastream.sink;

import com.javayh.advanced.flink.entity.Person;
import com.javayh.advanced.flink.util.GenerateStream;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.advanced.flink.datastream.sink → SinkFileExample
 * @since 2022-06-20
 */
public class SinkFileExample {

    public static void main(String[] args) {
        DataStreamSource<Person> generate = GenerateStream.generatePerson();
        StreamingFileSink<String> fileSink = StreamingFileSink
                // 按照行输出
                .<String>forRowFormat(new Path("./output"),
                        new SimpleStringEncoder<>("UTF-8"))
                // 指定策略
                .withRollingPolicy(
                        DefaultRollingPolicy.builder()
                                .withRolloverInterval(TimeUnit.MINUTES.toMillis(15))
                                .withInactivityInterval(TimeUnit.MINUTES.toMillis(5))
                                .withMaxPartSize(1024 * 1024 * 1024)
                                .build())
                .build();
        // 将 Event 转换成 String 写入文件
        generate.map(Person::toString).addSink(fileSink);
        GenerateStream.execute();
    }
}
