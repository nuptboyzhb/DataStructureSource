/*
 * $filename: MyCircularLinkedList.java,v $
 * $Date: 2014-3-10  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-10  Nanjing,njupt,China
 */
/**
 * 有序循环链表
 */
public class MyCircularLinkedList {
	/**
	 * 定义节点
	 */
	public class Node{
		public Node next;
		public int data;
	}
	/**
	 * 有序循环链表
	 * @param head 有序循环链表的头
	 * @param data 带插入的数据
	 */
	public void insert(Node head,int data){
		if(head==null){
			head=new Node();
			head.data=data;
			//head.next=head;
			System.out.println("insert "+data);
			return;
		}
		Node p = head.next;
		Node preNode = head;
		while(p!=head){
			if(data>=preNode.data&&data<=p.data){//当前插入值的大小恰好在preNode和p之间
				break;
			}
			if((data>=preNode.data||data<=p.data)&&(p.data<preNode.data)){//插入的值在最大值和最小值的衔接处
				break;
			}
			preNode=p;//移动指针
			p=p.next;
		}
		//跳出循环后，找到了插入的位置preNode和P之间
		Node node = new Node();
		node.data=data;
		node.next=p;
		preNode.next=node;
	}
	/**
	 * 打印有序循环链表
	 * @param head
	 */
	public void display(Node head){
		if(head==null){
			return;
		}
		Node p = head.next;
		while(p!=head){
			System.out.print(p.data+" ");
			p=p.next;
		}
	}
	/**
	 * 测试
	 */
	public void test(){
		Node head = new Node();
		head.data=1;
		head.next=head;
		int []datas={2,5,3,7,8,10,4,3};
		for(int a:datas){
			insert(head, a);
		}
		display(head);
	}
	public static void main(String[] args) {
		new MyCircularLinkedList().test();
	}
}
