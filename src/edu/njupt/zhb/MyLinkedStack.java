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
 * 用链表方式实现栈
 */
public class MyLinkedStack {
	/**
	 * 链表的节点
	 */
	public class Node{
		public Node next;
		public Object data;
	}
	private Node top;//栈顶指针
	private int size;
	public MyLinkedStack(){
		top = new Node();
		top.next = null;
		size = 0;
	}
	/**
	 * 入栈
	 * @param object
	 */
	public void push(Object object){//将节点插入到top和top的下一个节点之间
		Node node = top.next;//取出下一个节点
		Node newNode = new Node();
		newNode.data = object;
		newNode.next = node;
		top.next=newNode;
		size++;
	}
	/**
	 * 出栈
	 * @return
	 */
	public Object pop(){
		Node node = top.next;//取出栈顶节点
		Object object = node.data;//取出站定节点所保存的数据
		top.next= top.next.next;//删除栈顶的元素
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
	 * 获取栈顶元素，但是不出栈
	 * peek(偷看一眼)
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
