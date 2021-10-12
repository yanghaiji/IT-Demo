package com.javayh.concurrent.scheduled;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-10-12
 */
@Slf4j
public class ScheduledTest {
    static ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(10, Executors.defaultThreadFactory());
    static BlockingQueue<Runnable> queue2 = new LinkedBlockingDeque<>();
    static BlockingQueue<Runnable> queue = scheduledExecutor.getQueue();

    public static void main(String[] args) throws ExecutionException {

        scheduledExecutor.scheduleAtFixedRate(new Runner(), 1, 2, TimeUnit.SECONDS);
    }


    private static class Runner implements Runnable {
        @Override
        public void run() {
            OpcConn opcConn = new OpcConn();
            log.info("queue = " + queue2.size());
            log.info("开始执行........");
            Future future = scheduledExecutor.submit(opcConn);
            try {
                future.get(1, TimeUnit.SECONDS);
                log.info("future 执行........");
            } catch (TimeoutException e) {
                log.info("timeout........");
                queue2.add(new Runner());
                //queue.addAll(queue2);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                log.info("queue = " + queue2.size());
                scheduledExecutor.shutdown(); // 强制终止任务
            }
        }
    }

    private static class OpcConn implements Callable {
        @Override
        public Boolean call() {
            try {
                Thread.sleep(10000);
                System.out.println(new Date());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

}
