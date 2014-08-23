/*
 * $filename: MyHashSet.java,v $
 * $Date: 2014-3-25  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-25  Nanjing,njupt,China
 */
public class MyHashSet<T>{
	/**
	 * 节点
	 */
	public class MyEntry<T>{
		public T data;//当前数据
		public MyEntry<T> next;
	}
	
	private MyEntry<T> []tables;//数组
	private final int INIT_LEN=50;
	private int size;
	public MyHashSet(){
		tables=new MyEntry[INIT_LEN];
		size=0;
	}
	/**
	 * 哈希函数构造方法
	 * @param hashcode 哈希值
	 * @return 对应的数组下标
	 */
	private int indexFor(int hashcode){
		return Math.abs(hashcode)%tables.length;
	}
	/**
	 * 添加元素
	 * @param object
	 * @return
	 */
	public boolean add(T data){
		if(data==null){
			return false;
		}
		int hashcode=data.hashCode();//计算哈希值
		int index=indexFor(hashcode);//定位存储的位置
		MyEntry<T> head=tables[index];//取出该位置的第一个元素（链表的头）
		MyEntry<T> pNode=head;//查找链表中是否存在
		while(pNode!=null){
			if(pNode.data.hashCode()==hashcode&&(pNode.data==data||pNode.data.equals(data))){
				return false;//已经存在重复的元素
			}
			pNode=pNode.next;
		}
		//不存在重复的元素或该位置为空,将该节点添加到链表的头
		MyEntry<T> newNode=new MyEntry<T>();
		newNode.data=data;
		newNode.next=head;
		tables[index]=newNode;
		size++;
		return true;
	}
	
	public boolean remove(T data){
		if(data==null){
			return false;
		}
		int hashcode=data.hashCode();
		int index=indexFor(hashcode);
		MyEntry<T> head=tables[index];
		MyEntry<T> pNode=head;
		if(pNode.data.hashCode()==hashcode&&(pNode.data==data||pNode.data.equals(data))){
			tables[index]=pNode.next;
			size--;
			return true;
		}
		while(pNode.next!=null){
			if(pNode.next.data.hashCode()==hashcode&&(pNode.next.data==data||pNode.next.data.equals(data))){
				pNode.next=pNode.next.next;//删除该元素
				size--;
				return true;
			}
			pNode=pNode.next;
		}
		return false;
	}
	
	public void print(){
		for(int i=0;i<tables.length;i++){
			MyEntry<T> entry=tables[i];
			if(entry!=null){
				while(entry!=null){
					System.out.println(entry.data);
					entry=entry.next;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashSet<String> set=new MyHashSet<String>();
		for(int i=0;i<100;i++){
			set.add(i+"");
		}
		for(int i=0;i<10;i++){
			set.remove(i+"");
		}
		System.out.println(set.size);
		set.print();
	}

}
