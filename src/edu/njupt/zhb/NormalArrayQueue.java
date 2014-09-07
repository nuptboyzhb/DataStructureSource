/*
 * $filename: NormalArrayQueue.java,v $
 * $Date: 2014-9-6  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;


/*
 *@author: ZhengHaibo  
 *blog:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *web:     http://www.mobctrl.net
 *2014-9-6  Nanjing,njupt,China
 */
public class NormalArrayQueue {
	private Object[] objects;
	private int maxSize;
	private int front;
	private int rear;

	public NormalArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		objects = new Object[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean enqueue(Object data) {
		if (rear == maxSize - 1) {
			System.out.println("队列已满...");
			return false;
		}
		objects[++rear] = data;
		return true;
	}

	public boolean enqueue2(Object data) {
		if ((rear + 1) % maxSize == front) {
			System.out.println("队列已满...");
			return false;
		}
		rear = (rear + 1) % maxSize;
		objects[rear] = data;
		return true;
	}

	public Object dequeue() {
		if (front != rear)
			return objects[++front];
		return null;
	}

	public Object dequeue2() {
		if (front == rear)
			return null;
		front = (front + 1) % maxSize;
		return objects[front];
	}

	private static void test1() {
		NormalArrayQueue queue = new NormalArrayQueue(4);
		queue.enqueue("1");
		queue.enqueue("2");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue("3");
		queue.enqueue("4");
		queue.enqueue("5");
	}

	private static void test2() {
		NormalArrayQueue queue = new NormalArrayQueue(4);
		queue.enqueue2("1");
		queue.enqueue2("2");
		System.out.println(queue.dequeue2());
		System.out.println(queue.dequeue2());
		queue.enqueue2("3");
		queue.enqueue2("4");
		queue.enqueue2("5");
	}

	public static void main(String[] args) {
		test1();
	}

}
