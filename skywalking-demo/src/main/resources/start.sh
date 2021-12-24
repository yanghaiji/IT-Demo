#!/bin/sh
# SkyWalking Agent配置
## 需要在启动的脚本里加入如下参数，请将skywalking-agent 的路径指定到自己的安装路径
# skywalking-agent 的具体位置
#-javaagent:./apache-skywalking-apm-bin/agent/skywalking-agent.jar
# 服务名称
#-Dskywalking.agent.service_name=${you service_name}
# 采集的后端地址 当机器不在一个服务上时需要指定
#-Dskywalking.collector.backend_service=127.0.0.1:11800
export SW_AGENT_NAME=skywalking-demo #Agent名字,一般使用`spring.application.name`
export SW_AGENT_COLLECTOR_BACKEND_SERVICES=192.168.1.180:11800 #配置 Collector 地址。
export SW_AGENT_SPAN_LIMIT=2000 #配置链路的最大Span数量，默认为 300。
export JAVA_AGENT=-javaagent:/opt/module/skywalking-apm-bin-es7/agent/skywalking-agent.jar
java $JAVA_AGENT -jar /opt/module/demo/user-center-0.0.1-SNAPSHOT.jar #jar启动



