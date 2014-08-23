/*
 * $filename: MyLinkedStack.java,v $
 * $Date: 2014-3-11  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-11  Nanjing,njupt,China
 */
/**
 * ������ʽʵ��ջ
 */
public class MyLinkedStack {
	/**
	 * ����Ľڵ�
	 */
	public class Node{
		public Node next;
		public Object data;
	}
	private Node top;//ջ��ָ��
	private int size;
	public MyLinkedStack(){
		top = new Node();
		top.next = null;
		size = 0;
	}
	/**
	 * ��ջ
	 * @param object
	 */
	public void push(Object object){//���ڵ���뵽top��top����һ���ڵ�֮��
		Node node = top.next;//ȡ����һ���ڵ�
		Node newNode = new Node();
		newNode.data = object;
		newNode.next = node;
		top.next=newNode;
		size++;
	}
	/**
	 * ��ջ
	 * @return
	 */
	public Object pop(){
		Node node = top.next;//ȡ��ջ���ڵ�
		Object object = node.data;//ȡ��վ���ڵ������������
		top.next= top.next.next;//ɾ��ջ����Ԫ��
		size--;
		return object;
	}
	/**
	 * 
	 * @return
	 */
	public int getSize(){
		return size;
	}
	/**
	 * ��ȡջ��Ԫ�أ����ǲ���ջ
	 * peek(͵��һ��)
	 * @return
	 */
	public Object peek(){
		return top.next;
	}
	
	public boolean isEmpty(){
		if(top.next==null){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyArrayStack arrayStack = new MyArrayStack();
		for(int i=0;i<30;i++){
			arrayStack.push("--"+i);
		}
		while(!arrayStack.isEmpty()){
			System.out.println((String)arrayStack.pop());
		}
	}
	
}
