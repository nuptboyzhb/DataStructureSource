/*
 * $filename: MySingleLinkedList.java,v $
 * $Date: 2014-3-10  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-10  Nanjing,njupt,China
 */
/**
 * ������
 */
public class MySingleLinkedList {
	/**
	 * ����ڵ�����ݽṹ
	 */
	public class Node {
		public Node next;//�洢��һ���ڵ�ĵ�ַ
		public int data;//������
	}
	/**
	 * ����ڵ�
	 * @param head �����ͷ
	 * @param data Ҫ����Ľڵ�����
	 * @param i �����λ��
	 */
	public boolean insert(Node head,int data,int i){
		Node p = head;
		int j = 0;
		while(p!=null&&j<i-1){
			p=p.next;
			j++;
		}
		if(p==null||j>i-1){//i���ڱ���+1 ���� i<1
			System.out.println("ERROR");
			return false;
		}
		Node node = new Node();
		node.data = data;
		node.next = p.next;
		p.next = node;
		return true;
	}
	/**
	 * ɾ����i��Ԫ�أ����ҽ�ɾ�����Ԫ�ر�����data��
	 * @param head �����ͷ
	 * @param i ɾ��Ԫ�ص�λ��
	 * @param data ɾ��Ԫ�ص�������
	 * @return
	 */
	public boolean remove(Node head,int i,int data){
		Node p = head;
		int j = 0;
		while(p.next!=null&&j<i-1){//Ѱ����i���ڵ㣬����pָ����ǰ��
			p=p.next;
			j++;
		}
		if(p.next==null||j>i-1){//ɾ����λ�ò�����
			return false;
		}
		data = p.next.data;//��Ҫɾ���ĵ�����ݱ��浽data��
		p.next = p.next.next;//ɾ��p.next
		return true;
	}
	/**
	 * �ϲ�2����������(�ǵݼ�)
	 * @param head1 ���ϲ�����������1
	 * @param head2 ���ϲ�����������2
	 * @param head �ϲ������������
	 */
	public void mergeList(Node head1,Node head2,Node head){
		 Node pa = head1.next;
		 Node pb = head2.next;
		 Node pc = head;
		 while(pa!=null&&pb!=null){
			 if(pa.data<pb.data){
				 pc.next=pa;
				 pc=pc.next;
				 pa=pa.next;
			 }else {
				pc.next=pb;
				pc=pc.next;
				pb=pb.next;
			}
		 }
		 if(pa==null)pc.next=pb;
		 if(pb==null)pc.next=pa;
	}
	
	public Node mergeList(Node head1,Node head2){
		 Node pa = head1.next;
		 Node pb = head2.next;
		 Node head = new Node();
		 Node pc = head;
		 while(pa!=null&&pb!=null){
			 if(pa.data<pb.data){
				 pc.next=pa;
				 pc=pc.next;
				 pa=pa.next;
			 }else {
				pc.next=pb;
				pc=pc.next;
				pb=pb.next;
			}
		 }
		 if(pa==null)pc.next=pb;
		 if(pb==null)pc.next=pa;
		 return head;
	}
	/**
	 * ��ת������
	 * Ϊ�˷�ת�����������������ͷ����next��ָ����2��
	 * ���ý��1��next��ָ����3����󽫽��2��next��ָ����1��
	 * ������˵�һ�ν�����˳��ͱ����Header-���2-���1-���3-���4-NULL��
	 * Ȼ�������ͬ�Ľ��������3�ƶ������2��ǰ�棬
	 * Ȼ���ٽ����4�ƶ������3��ǰ�棬���ν�����
	 * @param head
	 */
	public void reverseList(Node head){
		if(head==null){
			return;
		}
		Node fristNode=head.next;//�ýڵ�ʼ��ָ��ԭ����ĵ�һ���ڵ�
		while(fristNode.next!=null){
			Node p=fristNode.next;
			fristNode.next=fristNode.next.next;
			p.next=head.next;
			head.next=p;
		}
	}
	/**
	 * ����ջ��������з�ת
	 * @param head
	 */
	public void reverseListStack(Node head){
		Stack<Node> stack=new Stack<Node>();
		Node pNode=head;
		while (pNode.next!=null) {//��ջ
			pNode=pNode.next;
			stack.push(pNode);
		}
		Node pp=head;
		while(!stack.isEmpty()){//��ջ
			Node node=stack.pop();
			pp.next=node;
			pp=node;
		}
		pp.next=null;//��ֹ����ѭ������
	}
	/**
	 * ��ȡ����ĳ���
	 * @param head
	 * @return
	 */
	public int getListLen(Node head){
		Node p=head;
		int len=0;
		while(p.next!=null){
			p=p.next;
			len++;
		}
		return len;
	}
	/**
	 * ��ȡ�����еĵ�����K���ڵ�
	 * ˼·1���Ȼ�ȡ����ĳ���n��Ȼ����ȡ��n+1-k��Ԫ��
	 * @param head
	 * @param k 
	 * @return
	 */
	public Node reGetKthNode1(Node head,int k){
		int len=0;
		Node p=head;
		while(p.next!=null){//����������
			len++;
			p=p.next;
		}
		if(k<1||k>len){
			return null;
		}
		Node ppNode=head;
		int index=0;
		while(ppNode.next!=null){
			ppNode=ppNode.next;
			index++;
			if(index==len+1-k){
				return ppNode;
			}
		}
		return null;
	}
	/**
	 * ��ȡ�����еĵ�����K���ڵ�
	 * ˼·2������2��ָ��p1��p2������p2�ƶ�k-1��
	 * Ȼ����p1��p2һ���ƶ���ֱ��p2.next==null��ʱ��
	 * p1��Ϊ������K��Ԫ��
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reGetKthNode2(Node head,int k){
		Node p1=head,p2=head;
		int step=0;
		while(p2.next!=null&&step<k-1){//ʹp2����p1 (k-1)����
			p2=p2.next;
			step++;
		}
		if(p2.next==null||step!=k-1){
			return null;
		}
		while (p2.next!=null) {
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
	}
	/**
	 * �ж������Ƿ��л�
	 * @param head
	 * @return
	 */
	public boolean isLoopList(Node head){
		Node p1=head,p2=head;
		while(p1!=null&&p2.next!=null){
			p1=p1.next;
			p2=p2.next.next;
			if(p1==p2){
				return true;
			}
		}
		return false;
	}

	/**
	 * �ڵ�k���ڵ�����һ������ʹβ��ָ���K���ڵ�
	 * @param head
	 */
	public boolean makeLoopInKth(Node head,int k){
		Node p1=head,p2=head;
		while(p1.next!=null){//�ƶ������һ���ڵ�
			p1=p1.next;
		}
		int index=0;
		while(p2.next!=null&&index<k){
			p2=p2.next;
			index++;
		}
		p1.next=p2;//��β���ڵ�ָ��
		return true;
	}
	/**
	 * ���������д��ڻ�����ȡ���еĵ�һ���ڵ�
	 * ���û�У�����null
	 * ˼·��HashMap������key�����ظ����ص�
	 * @param head
	 * @return
	 */
	public Node getFirstLoopNode(Node head){
		Node p=head;
		Map<Node,String> map=new HashMap<Node,String>();
		while(p.next!=null){
			p=p.next;
			if(map.get(p)==null){//���map�л�û������ڵ㣬����put����
				map.put(p, "1");
			}else {
				return p;
			}
		}
		return null;
	}
	/**
	 * ����������������һ���ཻ��
	 * ��head2�ĵ����ڶ����ڵ�����һ���ཻ��
	 * @param head1
	 * @param head2
	 */
	public void makeCrossingNode(Node head1,Node head2){
		Node p1=head1;
		Node p2=head2;
		while(p1.next!=null){
			p1=p1.next;
		}
		while(p2.next.next!=null){
			p2=p2.next;
		}
		p1.next=p2;
	}
	/**
	 * �ж�2�������Ƿ��ཻ
	 * ˼·�������������������һ���ڵ��Ƿ���ͬ
	 * @param head1
	 * @param head2
	 * @return
	 */
	public boolean isListCrossing(Node head1,Node head2){
		Node p1=head1;
		Node p2=head2;
		while(p1.next!=null){
			p1=p1.next;
		}
		while(p2.next!=null){
			p2=p2.next;
		}
		return p1==p2;
	}
	/**
	 * ��ȡ�����ཻ����ĵ�һ�������ڵ�
	 * ˼·1��HashMap ȱ�㣺�����˿ռ临�Ӷ�
	 * ˼·2��
	 * �Ե�һ��������������㳤��len1��ͬʱ�������һ���ڵ�ĵ�ַ�� 
     * �Եڶ���������������㳤��len2��ͬʱ������һ���ڵ��Ƿ��
     * ��һ����������һ���ڵ���ͬ��������ͬ�����ཻ�������� 
     * �����������ͷ�ڵ㿪ʼ������len1����len2 
     * ����ô����һ�������ȱ���len1-len2���ڵ㣬��ʱ��������ǰ
     * �ڵ㵽��һ���ཻ�ڵ�ľ��������ˣ�Ȼ��һ����������ֱ��
     * �����ڵ�ĵ�ַ��ͬ�� 
     * ʱ�临�Ӷȣ�O(len1+len2) 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node getFristCrossingNode(Node head1,Node head2){
		Node p1=head1;
		Node p2=head2;
		int len1=0,len2=0;
		while(p1.next!=null){
			len1++;
			p1=p1.next;
		}
		while(p2.next!=null){
			len2++;
			p2=p2.next;
		}
		if(p2!=p1){//˵�����ཻ
			return null;
		}
		Node pp1=head1;
		Node pp2=head2;
		int step;//���㳤������ȶ̵������˶���
		if(len1>=len2){
			step=len1-len2;
			for(int i=0;i<step;i++){
				pp1=pp1.next;
			}
		}else {
			step=len2-len1;
			for(int i=0;i<step;i++){
				pp2=pp2.next;
			}
		}
		while(pp1!=pp2){
			pp1=pp1.next;
			pp2=pp2.next;
		}
		return pp1;
	}
	/**
	 * ��ӡ����
	 * @param head
	 */
	public void displayList(Node head){
		Node p = head;
		while(p.next!=null){
			p=p.next;
			System.out.println(p.data);
		}
	}
	/**
	 * ��ӡ����
	 * @param head
	 * @param len ��ӡ���Ȳ�����len
	 */
	public void displayList(Node head,int len){
		Node p = head;
		int index=0;
		while(p.next!=null&&index<len){
			p=p.next;
			index++;
			System.out.println(p.data);
		}
	}
	
	public Node sortLinkedList(Node head){
		if(null == head || null == head.next){
			return head;
		}
		int len = 0;
		Node p = head;
		while(p.next !=null){
			p=p.next;
			len++;
		}
		int mid = len/2;
		Node left = head;
		Node right = null;
		Node p2 = head;
		int count = 0;
		while(p2!=null){
			count++;
			if(count == mid){
				right = p2.next;
				p2.next = null;
				break;
			}
			p2 = p2.next;
		}
		Node head1 = sortLinkedList(left);
		Node head2 = sortLinkedList(right);
		mergeList(head1, head2,head);
		return head;
	}
	
	public void test(){
		Node headNode = new Node();
		int []datas = {32,45,8,2,1,4,5,87,57};
		for(int i=0;i<datas.length;i++){//���ν����ݲ��뵽������
			insert(headNode, datas[i],i+1);
		}
		Node resultNode = sortLinkedList(headNode.next);
//		int removeData=0;
		displayList(resultNode);
//		remove(headNode,4,removeData);
//		System.out.println("-------ɾ��֮��---------");
//		displayList(headNode);
		///////////////////////////////////////////
//		Node headNode1 = new Node();
//		Node headNode2 = new Node();
//		Node node3 = new Node();
//		int []datas1 = {1,3,5,7,9,11};
//		int []datas2 = {2,3,6,8,12};
//		for(int i=0;i<datas1.length;i++){//���ν����ݲ��뵽������
//			insert(headNode1, datas1[i],i+1);
//		}
//		for(int i=0;i<datas2.length;i++){//���ν����ݲ��뵽������
//			insert(headNode2, datas2[i],i+1);
//		}
//		mergeList(headNode1, headNode2, node3);
//		displayList(node3);
		////////////////////////////////////////////
//		Node headNode = new Node();
//		int []datas = {32,45,8,2,1,4,5,87,57};
//		for(int i=0;i<datas.length;i++){//���ν����ݲ��뵽������
//			insert(headNode, datas[i],i+1);
//		}
//		reverseList(headNode);
		//reverseListStack(headNode);
//		displayList(headNode);
		//System.out.println(getListLen(headNode));
		//System.out.println(reGetKthNode2(headNode,2).data);
		//System.out.println(isLoopList(headNode));
        //makeLoopInKth(headNode, 4);//�ڵ�4���ڵ㣬��Ϊ�γ�һ����
		//displayList(headNode, 30);
		//System.out.println(isLoopList(headNode));
		//Node node=getFirstLoopNode(headNode);
		//if(node!=null){
		//	System.out.println(node.data);
		//}
//		Node headNode2 = new Node();
//		int []datas2 = {9,8,7,6,51};
//		for(int i=0;i<datas2.length;i++){//���ν����ݲ��뵽������
//			insert(headNode2, datas2[i],i+1);
//		}
//		makeCrossingNode(headNode, headNode2);//��Ϊ����һ���ཻ��
//		System.out.println(isListCrossing(headNode, headNode2));
//		Node node2=getFristCrossingNode(headNode, headNode2);
//		System.out.println(node2.data);
	}
	public static void main(String[] args) {
		new MySingleLinkedList().test();
	}
}
