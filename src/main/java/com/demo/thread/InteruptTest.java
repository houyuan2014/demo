package com.demo.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InteruptTest {

	private static final Logger logger = LoggerFactory.getLogger(InteruptTest.class);

	public static void main(String[] args) throws InterruptedException {
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		executor.execute(new Task("0"));
		Thread.sleep(1);
		executor.shutdown();
		logger.info("executor has been shutdown");
	}

	static class Task implements Runnable {
		String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {

			for (int i = 1; i <= 100 && !Thread.interrupted(); i++) {
				Thread.yield();
				logger.info("task " + name + " is running, round " + i);
			}

		}
	}
}
