package com.demo.thread;
/**
 */
public class ThreadSyncDemo {
	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		//
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					bussiness.subMethod();
				}
			}
		}).start();
		//
		for (int i = 0; i < 3; i++) {
			bussiness.mainMethod();
		}
	}

}

class Bussiness {
	private boolean subFlag = true;

	public synchronized void mainMethod() {
		while (subFlag) {
			try {
//				System.out.println("mainMethod wait before");
				wait();
//				System.out.println("mainMethod wait after");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : main thread running loop count -- " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		subFlag = true;
		notify();
	}

	public synchronized void subMethod() {
		while (!subFlag) {
			try {
//				System.out.println("subMethod wait before");
				wait();
//				System.out.println("subMethod wait after");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.err.println(Thread.currentThread().getName() + " : sub thread running loop count -- " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		subFlag = false;
		notify();
	}
}
