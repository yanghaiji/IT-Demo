package com.javayh.hystrix.demo.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-07-11
 */
@Slf4j
public class Example2Service extends HystrixCommand<String> {


    protected Example2Service(HystrixCommandGroupKey group) {
        super(group);
    }

    protected Example2Service(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool) {
        super(group, threadPool);
    }

    protected Example2Service(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected Example2Service(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, threadPool, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected Example2Service(Setter setter) {
        super(setter);
    }

    @Override
    protected String getFallback() {
        return super.getFallback();
    }

    @Override
    protected String run() throws Exception {
        /* simulate performing network call to retrieve order */
        try {
            Thread.sleep((int) (Math.random() * 200) + 50);
        } catch (InterruptedException e) {
            // do nothing
        }

        /* fail rarely ... but allow failure as this one has no fallback */
        if (Math.random() > 0.9999) {
            throw new RuntimeException("random failure loading order over network");
        }

        /* latency spike 5% of the time */
        if (Math.random() > 0.95) {
            // random latency spike
            try {
                Thread.sleep((int) (Math.random() * 300) + 25);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
        return "正常服务的访问呢....";
    }
}
