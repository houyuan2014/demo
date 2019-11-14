package com.demo.thread;

import java.util.concurrent.Semaphore;
/**
 *
 */
public class ThreadCommunication {

	private static int num = 0;
	private static Semaphore semaphore = new Semaphore(0, false);

	public static void main(String[] args) {
		Thread threadA = new Thread(new Runnable() {
			public void run() {
				try {
					// ģ���ʱ����
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				num = 1;
				semaphore.release(2);
			}
		});
		Thread threadB = new Thread(new Runnable() {
			public void run() {
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "��ȡ��num ��" + num);
			}
		});
		Thread threadC = new Thread(new Runnable() {
			public void run() {
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "��ȡ��num ��" + num);
			}
		});
		threadA.start();
		threadB.start();
		threadC.start();
	}

}
