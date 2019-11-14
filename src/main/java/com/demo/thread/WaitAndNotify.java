package com.demo.thread;
/**
 * 调用wait方法和notify、notifyAll方法前必须获得对象锁，也就是必须写在synchronized(锁对象){......}代码块中
 * https://www.cnblogs.com/lyx210019/p/9427146.html
 */
public class WaitAndNotify {

	private int flag = 1;

	public void print1() throws Exception {
		synchronized (this) {
			while (flag != 1) {
				this.wait();
			}
			System.out.print("1");
			System.out.print("2");
			System.out.print("3");
			System.out.print("4");
			System.out.println();
			flag = 2;
			this.notifyAll();
		}
	}

	public void print2() throws Exception {
		synchronized (this) {
			while (flag != 2) {
				this.wait();
			}
			System.out.print("5");
			System.out.print("6");
			System.out.print("7");
			System.out.print("8");
			System.out.println();
			flag = 3;
			this.notifyAll();
		}
	}

	public void print3() throws Exception {
		synchronized (this) {
			while (flag != 3) {
				this.wait();
			}
			System.out.print("A");
			System.out.print("B");
			System.out.print("C");
			System.out.print("D");
			System.out.println();
			flag = 1;
			this.notifyAll();
		}
	}

	private final static WaitAndNotify waitAndNotify = new WaitAndNotify();

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					waitAndNotify.print1();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					waitAndNotify.print2();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					waitAndNotify.print3();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
	}
}
