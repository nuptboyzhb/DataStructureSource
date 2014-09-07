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
 * 单链表
 */
public class MySingleLinkedList {
	/**
	 * 定义节点的数据结构
	 */
	public class Node {
		public Node next;//存储下一个节点的地址
		public int data;//数据区
	}
	/**
	 * 插入节点
	 * @param head 链表的头
	 * @param data 要插入的节点数据
	 * @param i 插入的位置
	 */
	public boolean insert(Node head,int data,int i){
		Node p = head;
		int j = 0;
		while(p!=null&&j<i-1){
			p=p.next;
			j++;
		}
		if(p==null||j>i-1){//i大于表长度+1 或者 i<1
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
	 * 删除第i个元素，并且将删除后的元素保存在data中
	 * @param head 链表的头
	 * @param i 删除元素的位置
	 * @param data 删除元素的数据区
	 * @return
	 */
	public boolean remove(Node head,int i,int data){
		Node p = head;
		int j = 0;
		while(p.next!=null&&j<i-1){//寻到第i个节点，并将p指向其前驱
			p=p.next;
			j++;
		}
		if(p.next==null||j>i-1){//删除的位置不合理
			return false;
		}
		data = p.next.data;//将要删除的点的数据保存到data中
		p.next = p.next.next;//删除p.next
		return true;
	}
	/**
	 * 合并2个有序链表(非递减)
	 * @param head1 待合并的有序链表1
	 * @param head2 待合并的有序链表2
	 * @param head 合并后的有序链表
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
	 * 反转单链表
	 * 为了反转这个单链表，我们先让头结点的next域指向结点2，
	 * 再让结点1的next域指向结点3，最后将结点2的next域指向结点1，
	 * 就完成了第一次交换，顺序就变成了Header-结点2-结点1-结点3-结点4-NULL，
	 * 然后进行相同的交换将结点3移动到结点2的前面，
	 * 然后再将结点4移动到结点3的前面，依次将类推
	 * @param head
	 */
	public void reverseList(Node head){
		if(head==null){
			return;
		}
		Node fristNode=head.next;//该节点始终指向原链表的第一个节点
		while(fristNode.next!=null){
			Node p=fristNode.next;
			fristNode.next=fristNode.next.next;
			p.next=head.next;
			head.next=p;
		}
	}
	/**
	 * 借助栈对链表进行翻转
	 * @param head
	 */
	public void reverseListStack(Node head){
		Stack<Node> stack=new Stack<Node>();
		Node pNode=head;
		while (pNode.next!=null) {//入栈
			pNode=pNode.next;
			stack.push(pNode);
		}
		Node pp=head;
		while(!stack.isEmpty()){//出栈
			Node node=stack.pop();
			pp.next=node;
			pp=node;
		}
		pp.next=null;//防止出现循环链表
	}
	/**
	 * 获取链表的长度
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
	 * 获取链表中的倒数第K个节点
	 * 思路1：先获取链表的长度n，然后求取第n+1-k个元素
	 * @param head
	 * @param k 
	 * @return
	 */
	public Node reGetKthNode1(Node head,int k){
		int len=0;
		Node p=head;
		while(p.next!=null){//计算链表长度
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
	 * 获取链表中的倒数第K个节点
	 * 思路2：定义2个指针p1和p2，先让p2移动k-1步
	 * 然后再p1和p2一起移动，直到p2.next==null的时候，
	 * p1即为倒数第K个元素
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reGetKthNode2(Node head,int k){
		Node p1=head,p2=head;
		int step=0;
		while(p2.next!=null&&step<k-1){//使p2领先p1 (k-1)步长
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
	 * 判断链表是否有环
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
	 * 在第k个节点制作一个环，使尾部指向第K个节点
	 * @param head
	 */
	public boolean makeLoopInKth(Node head,int k){
		Node p1=head,p2=head;
		while(p1.next!=null){//移动到最后一个节点
			p1=p1.next;
		}
		int index=0;
		while(p2.next!=null&&index<k){
			p2=p2.next;
			index++;
		}
		p1.next=p2;//将尾部节点指向
		return true;
	}
	/**
	 * 假设链表中存在环，获取环中的第一个节点
	 * 如果没有，返回null
	 * 思路：HashMap中利用key不能重复的特点
	 * @param head
	 * @return
	 */
	public Node getFirstLoopNode(Node head){
		Node p=head;
		Map<Node,String> map=new HashMap<Node,String>();
		while(p.next!=null){
			p=p.next;
			if(map.get(p)==null){//如果map中还没有这个节点，将其put进入
				map.put(p, "1");
			}else {
				return p;
			}
		}
		return null;
	}
	/**
	 * 在两个链表中制作一个相交点
	 * 在head2的倒数第二个节点制作一个相交点
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
	 * 判断2个链表是否相交
	 * 思路：遍历两个链表，看最后一个节点是否相同
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
	 * 获取两条相交链表的第一个公共节点
	 * 思路1：HashMap 缺点：增加了空间复杂度
	 * 思路2：
	 * 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。 
     * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和
     * 第一个链表的最后一个节点相同，若不相同，不相交，结束。 
     * 两个链表均从头节点开始，假设len1大于len2 
     * ，那么将第一个链表先遍历len1-len2个节点，此时两个链表当前
     * 节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到
     * 两个节点的地址相同。 
     * 时间复杂度，O(len1+len2) 
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
		if(p2!=p1){//说明不相交
			return null;
		}
		Node pp1=head1;
		Node pp2=head2;
		int step;//计算长的链表比短的链表长了多少
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
	 * 打印链表
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
	 * 打印链表
	 * @param head
	 * @param len 打印长度不超过len
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
		for(int i=0;i<datas.length;i++){//依次将数据插入到链表中
			insert(headNode, datas[i],i+1);
		}
		Node resultNode = sortLinkedList(headNode.next);
//		int removeData=0;
		displayList(resultNode);
//		remove(headNode,4,removeData);
//		System.out.println("-------删除之后---------");
//		displayList(headNode);
		///////////////////////////////////////////
//		Node headNode1 = new Node();
//		Node headNode2 = new Node();
//		Node node3 = new Node();
//		int []datas1 = {1,3,5,7,9,11};
//		int []datas2 = {2,3,6,8,12};
//		for(int i=0;i<datas1.length;i++){//依次将数据插入到链表中
//			insert(headNode1, datas1[i],i+1);
//		}
//		for(int i=0;i<datas2.length;i++){//依次将数据插入到链表中
//			insert(headNode2, datas2[i],i+1);
//		}
//		mergeList(headNode1, headNode2, node3);
//		displayList(node3);
		////////////////////////////////////////////
//		Node headNode = new Node();
//		int []datas = {32,45,8,2,1,4,5,87,57};
//		for(int i=0;i<datas.length;i++){//依次将数据插入到链表中
//			insert(headNode, datas[i],i+1);
//		}
//		reverseList(headNode);
		//reverseListStack(headNode);
//		displayList(headNode);
		//System.out.println(getListLen(headNode));
		//System.out.println(reGetKthNode2(headNode,2).data);
		//System.out.println(isLoopList(headNode));
        //makeLoopInKth(headNode, 4);//在第4个节点，人为形成一个环
		//displayList(headNode, 30);
		//System.out.println(isLoopList(headNode));
		//Node node=getFirstLoopNode(headNode);
		//if(node!=null){
		//	System.out.println(node.data);
		//}
//		Node headNode2 = new Node();
//		int []datas2 = {9,8,7,6,51};
//		for(int i=0;i<datas2.length;i++){//依次将数据插入到链表中
//			insert(headNode2, datas2[i],i+1);
//		}
//		makeCrossingNode(headNode, headNode2);//人为制作一个相交点
//		System.out.println(isListCrossing(headNode, headNode2));
//		Node node2=getFristCrossingNode(headNode, headNode2);
//		System.out.println(node2.data);
	}
	public static void main(String[] args) {
		new MySingleLinkedList().test();
	}
}
