package com.javayh.hystrix.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Example1Service {

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public Integer example01() {
        // 实际的服务调用逻辑
        log.info("开始业务处理....");
        int num = 19 / 0;
        log.info("完成业务处理....");
        return num;
    }

    /**
     * 降级逻辑，返回备用响应
     */
    public Integer fallbackMethod() {
        // 实际的服务调用逻辑
        log.info("降级逻辑，返回备用响应，开始业务处理....");
        int num = 19 / 99;
        log.info("降级逻辑，返回备用响应，完成业务处理....");
        return num;
    }

    /**
     * circuitBreaker.requestVolumeThreshold参数是Hystrix断路器的请求阈值参数。它用于控制断路器的开启条件。
     * <p>
     * 当circuitBreaker.requestVolumeThreshold设置为10时，表示在滚动时间窗口内（默认为10秒），必须有至少10个请求才能计算错误百分比来决定是否打开断路器。如果在滚动时间窗口内的请求数不足10个，则不会触发断路器的开启条件。
     * <p>
     * 换句话说，circuitBreaker.requestVolumeThreshold定义了在断路器生效之前必须达到的请求数量。如果请求的错误百分比超过了预设的阈值，断路器将打开并触发降级逻辑。
     * <p>
     * 例如，假设你将circuitBreaker.requestVolumeThreshold设置为10，即至少需要10个请求才能开始计算错误百分比。如果在滚动时间窗口内的10个请求中有超过一半（例如6个）的请求失败或超时，那么断路器将打开，并触发降级逻辑。
     * <p>
     * 通过调整circuitBreaker.requestVolumeThreshold参数，你可以根据应用程序的负载和需求来配置断路器的敏感度。请根据你的具体业务场景和性能需求，选择适当的请求阈值来确保应用程序的稳定性和可靠性。
     * <p>
     * circuitBreaker.requestVolumeThreshold参数的配置，断路器将不会触发打开。因为在这种情况下，错误百分比为20%（2个错误请求 / 10个总请求），低于断路器的阈值。
     * <p>
     * 断路器的开启条件不仅取决于错误请求的数量，还取决于错误请求的百分比是否超过预设的阈值。在默认情况下，Hystrix断路器的阈值为50%，即错误百分比超过50%时，断路器将触发打开。
     * <p>
     * 如果你希望在只有少数几个错误请求的情况下也触发断路器的打开，可以调整circuitBreaker.errorThresholdPercentage参数。例如，将它设置为10，表示当错误百分比超过10%时，断路器将触发打开。
     * <p>
     * 在上述示例中，如果你将circuitBreaker.errorThresholdPercentage设置为10，并且仍然有2个错误请求，那么错误百分比为20%，超过了10%的阈值，断路器将打开并触发降级逻辑。
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod2",
            commandProperties = {
                    //服务调用超时
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
                    //断路器的错误百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"),
                    //当服务调用的错误百分比超过了预设的阈值，并且请求的数量达到了circuitBreaker.requestVolumeThreshold参数配置的阈值，断路器将打开并触发降级逻辑
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10")
            },
            //忽略某些异常
            ignoreExceptions = {IllegalArgumentException.class})
    public void example02() {
        // 实际的服务调用逻辑
        log("example02 start");
//        int num = 19 / 0;
        log("example02 end");
    }

    public void fallbackMethod2() {
        // 降级逻辑，返回备用响应
        logHystrixCommand("fallbackMethod2");
    }


    public void log(String met) {
        for (int i = 0; i < 5; i++) {
            log.info("{} 开始业务处理....", met);
        }
    }

    public void logHystrixCommand(String met) {
        for (int i = 0; i < 5; i++) {
            log.info("{} 降级逻辑，返回备用响应，开始业务处理....", met);
        }
    }


}
