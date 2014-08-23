/*
 * $filename: MyArrayCircularQueue.java,v $
 * $Date: 2014-3-12  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-12  Nanjing,njupt,China
 */
/**
 *实现循环队列操作：
 (1)为使入队和出队实现循环，可以利用取余运算符%
 (2)队头指针进一：front=(front+1) % maxSize
 (3)队尾指针进一：rear=(rear+1) % maxSize
 (4)空队列：当front==rear 时为空队列
 (5)满队列：当(rear+1) % maxSize ==front时为满队列。满队列时实际仍有一个元素的空间未使用。
 */
public class MyArrayCircularQueue implements MyQueue {

	private int front;
	private int rear;
	private final int maxSize = 10;
	private Object []objects;
	private int size;
	public MyArrayCircularQueue(){
		front=rear=0;
		size=0;
		objects=new Object[maxSize];
	}
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		if((rear+1)%maxSize==front){
			System.out.println("队列已满...");
			return;
		}
		rear=(rear+1)%maxSize;
		objects[rear]=object;
		size++;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(front==rear){
			System.out.println("队列已经空了...");
			return null;
		}
		front=(front+1)%maxSize;
		Object object = objects[front];
		size--;
		return object;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return objects[front+1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==rear;
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyArrayCircularQueue();
		for(int i=0;i<50;i++){
			queue.add("str"+i);
		}
		while(!queue.isEmpty()){
			Object object=queue.remove();
			System.out.println((String)object);
		}
	}
}
