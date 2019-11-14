package com.demo.thread;

import java.util.concurrent.Semaphore;
/**
 */
public class SemaphoreTest {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					test();
				}
			}).start();
		}
	}

	private static Semaphore semaphore = new Semaphore(5, true);

	public static void test() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "�����ˣ�");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "���ˣ�");
		semaphore.release();
	}
}
