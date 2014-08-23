/*
 * $filename: MyLinkedQueue.java,v $
 * $Date: 2014-3-12  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-12  Nanjing,njupt,China
 */
/**
 * 队列的链式实现
 */
public class MyLinkedQueue implements MyQueue{
	public class Node{
		Node next;
		Object data;
	}
	private Node front;//前面的指针
	private Node rear;//后面的指针
	private int size;
	public MyLinkedQueue(){
		front=new Node();
		front.next=null;
		rear=new Node();
		rear.next=null;
		size=0;
	}
	/**
	 * 入列，从尾部添加元素
	 */
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.data=object;
		if(size==0){//如果是空的
			front.next=node;
			rear.next=node;
			size++;
			return;
		}
		rear.next.next=node;//将尾节点指向新增节点
		rear.next=node;//将rear指针指向新增节点
		size++;
	}
	/**
	 * 出列，从头部取出元素，并删除
	 */
	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(front.next!=null){
			Object object=front.next.data;//取出当前队列的头元素
			front.next=front.next.next;//删除第一个元素
			size--;
			return object;
		}
		return null;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return front.next.data;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	public static void main(String[] args) {
		MyQueue queue = new MyLinkedQueue();
		for(int i=0;i<20;i++){
			queue.add("str"+i);
		}
		while(!queue.isEmpty()){
			Object object=queue.remove();
			System.out.println((String)object);
		}
	}
}
