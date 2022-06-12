package com.javayh.hadoop.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;


@Configuration
@ConditionalOnProperty(name = "hadoop.name-node")
@Slf4j
public class HadoopConfig {
    @Value("${hadoop.name-node}")
    private String nameNode;


    /**
     * Configuration conf=new Configuration（）；
     * 创建一个Configuration对象时，其构造方法会默认加载hadoop中的两个配置文件，
     * 分别是hdfs-site.xml以及core-site.xml，这两个文件中会有访问hdfs所需的参数值，
     * 主要是fs.default.name，指定了hdfs的地址，有了这个地址客户端就可以通过这个地址访问hdfs了。
     * 即可理解为configuration就是hadoop中的配置信息。
     *
     * @return
     */
    @Bean("fileSystem")
    public FileSystem createFs() throws Exception {
        //读取配置文件
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();

        conf.set("fs.defalutFS", nameNode);
        conf.set("dfs.replication", "3");
        URI uri = new URI(nameNode.trim());
        FileSystem fs = FileSystem.get(uri, conf, "root");
        log.info("fileSystem 加载了");
        System.out.println("fs.defaultFS: " + conf.get("fs.defaultFS"));
        return fs;
    }


}