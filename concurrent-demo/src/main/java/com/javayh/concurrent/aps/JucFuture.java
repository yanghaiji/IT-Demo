package com.javayh.concurrent.aps;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * J.U.C之Future
 *
 * @author ronglexie
 * @version 2018/4/28
 */
@Slf4j
public class JucFuture {

	static class MyCallabel implements Callable<String> {

		@Override
		public String call() throws Exception {
			log.info("do something in callable");
			Thread.sleep(1000);
			return "Done";
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> future = executorService.submit(new MyCallabel());
		log.info("do something in main");
		Thread.sleep(1000);
		String result = future.get();
		log.info("result: {}",result);
		executorService.shutdown();
	}
}
