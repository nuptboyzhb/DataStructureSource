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
 * ���е���ʽʵ��
 */
public class MyLinkedQueue implements MyQueue{
	public class Node{
		Node next;
		Object data;
	}
	private Node front;//ǰ���ָ��
	private Node rear;//�����ָ��
	private int size;
	public MyLinkedQueue(){
		front=new Node();
		front.next=null;
		rear=new Node();
		rear.next=null;
		size=0;
	}
	/**
	 * ���У���β�����Ԫ��
	 */
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.data=object;
		if(size==0){//����ǿյ�
			front.next=node;
			rear.next=node;
			size++;
			return;
		}
		rear.next.next=node;//��β�ڵ�ָ�������ڵ�
		rear.next=node;//��rearָ��ָ�������ڵ�
		size++;
	}
	/**
	 * ���У���ͷ��ȡ��Ԫ�أ���ɾ��
	 */
	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(front.next!=null){
			Object object=front.next.data;//ȡ����ǰ���е�ͷԪ��
			front.next=front.next.next;//ɾ����һ��Ԫ��
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
