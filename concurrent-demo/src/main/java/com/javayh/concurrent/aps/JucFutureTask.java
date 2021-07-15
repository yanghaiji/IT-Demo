package com.javayh.concurrent.aps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * J.U.C之FutureTask
 *
 * @author ronglexie
 * @version 2018/4/28
 */
@Slf4j
public class JucFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("do something in callable");
				Thread.sleep(1000);
				return "Done";
			}
		});

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(futureTask);
		log.info("do something in main");
		Thread.sleep(1000);
		String result = futureTask.get();
		log.info("result: {}",result);
		executorService.shutdown();
	}
}
