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
 * ����ѭ������
 */
public class MyCircularLinkedList {
	/**
	 * ����ڵ�
	 */
	public class Node{
		public Node next;
		public int data;
	}
	/**
	 * ����ѭ������
	 * @param head ����ѭ�������ͷ
	 * @param data �����������
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
			if(data>=preNode.data&&data<=p.data){//��ǰ����ֵ�Ĵ�Сǡ����preNode��p֮��
				break;
			}
			if((data>=preNode.data||data<=p.data)&&(p.data<preNode.data)){//�����ֵ�����ֵ����Сֵ���νӴ�
				break;
			}
			preNode=p;//�ƶ�ָ��
			p=p.next;
		}
		//����ѭ�����ҵ��˲����λ��preNode��P֮��
		Node node = new Node();
		node.data=data;
		node.next=p;
		preNode.next=node;
	}
	/**
	 * ��ӡ����ѭ������
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
	 * ����
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
