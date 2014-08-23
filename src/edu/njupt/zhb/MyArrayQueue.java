/*
 * $filename: MyArrayQueue.java,v $
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
public class MyArrayQueue implements MyQueue {

	private int size;
	private int front;
	private int rear;
	final int INIT_LEN=10;//初始化长度
	final int INCREAMENT_LEN=10;//长度增量大小
	Object []objects;//用数组保存队列中的元素
	public MyArrayQueue(){
		size=0;
		front=0;
		rear=-1;
		objects = new Object[INIT_LEN];
	}
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		if(size+1==objects.length){//扩充数组
			Object []temp = new Object[objects.length+INCREAMENT_LEN];
			for(int i=0;i<objects.length;i++){
				temp[i]=objects[i];
			}
			objects=temp;
		}
		objects[++rear]=object;//将元素添加在队列的尾部
		size++;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(size==0){
			return null;
		}
		Object object = objects[front];//取出队列的头元素
		for(int i=0;i<objects.length-1;i++){//通过平移，删除已取出的元素
			objects[i]=objects[i+1];
		}
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
		if(size==0){
			return null;
		}
		Object object = objects[front];//取出队列的头元素
		return object;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	public static void main(String[] args) {
		MyQueue queue = new MyArrayQueue();
		for(int i=0;i<20;i++){
			queue.add("str"+i);
		}
		while(!queue.isEmpty()){
			Object object=queue.remove();
			System.out.println((String)object);
		}
	}
}
