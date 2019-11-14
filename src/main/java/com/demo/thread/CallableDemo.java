package com.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Callable<String> myCallable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				System.out.println("calld ");
				return "callֵ";
			}
		};
		System.out.println(" " + getStringDate());
		Future<String> future = executor.submit(myCallable);
		System.out.println(" " + getStringDate());
		System.out.println(" " + future.get());
		System.out.println(" " + getStringDate());
		executor.shutdown();
	}

	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
}