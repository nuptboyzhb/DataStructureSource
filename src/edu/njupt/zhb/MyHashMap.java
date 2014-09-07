/*
 * $filename: MyHashMap.java,v $
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
public class MyHashMap<K,V>{
	/**
	 * HashMap数组中的节点
	 * @param <K>
	 * @param <V>
	 */
	public class MyEntry<K,V>{
		 public K key;//键
		 public V value;//值
		 public MyEntry<K,V> next;//下一个结点
	}
	
	private MyEntry<K, V> []tables;
	private final int INIT_LEN=50;
	public MyHashMap() {
		tables=new MyEntry[INIT_LEN];
	}
	/**
	 * 哈希函数的构造方法：除留余数法
	 * @param hashcode
	 * @return
	 */
	public int indexFor(int hashcode){
		return (hashcode & 0x7fffffff)%tables.length;
	}
	/**
	 * 获取键为key的值
	 * @param key
	 * @return
	 */
	public V get(K key){
		if(key==null){
			return null;
		}
		int hashcode=key.hashCode();//计算键的哈希值
		int index=indexFor(hashcode);//根据哈希值计算其在表中的下标index
		MyEntry<K, V> pNode=tables[index];//取出第一个节点，也即是链表的头
		//在链表中查找
		while(pNode!=null){//对链表进行遍历
			//当key的哈希值和真实值相等时返回
			if(pNode.key.hashCode()==hashcode&&(key==pNode.key || key.equals(pNode.key))){
				return pNode.value;
			}
			pNode=pNode.next;//链表：遍历下一个值
		}
		return null;
	}
	/**
	 * 将键值对放入map当中
	 * 解决冲突的方法：链地址法
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key,V value){
		if(key==null){
			return null;
		}
		int hashcode=key.hashCode();
		int index=indexFor(hashcode);
		MyEntry<K, V> head=tables[index];//取出第一个节点，也即是链表的头
		MyEntry<K, V> pNode=head;
		//首先查找是否已经存在key
		while(pNode!=null){
			//当key的哈希值和真实值相等时
			if(pNode.key.hashCode()==hashcode&&(key==pNode.key || key.equals(pNode.key))){
				pNode.value=value;//更新当前key的值
				return pNode.value;
			}
			pNode=pNode.next;//链表：遍历下一个值
		}
		//如果没有查找到，将该值插入到链表的表头
		MyEntry<K, V> newNode=new MyEntry<K,V>();
		newNode.key=key;
		newNode.value=value;
		newNode.next=head;
		tables[index]=newNode;
		return value;
	}
	/**
	 * 根据key删除对应的值
	 * 思路：先查找，后删除
	 * @param key
	 * @return
	 */
	public V remove(K key){
		if(key==null){
			return null;
		}
		int hashcode=key.hashCode();
		int index=indexFor(hashcode);
		MyEntry<K, V> head=tables[index];
		MyEntry<K, V> pNode=head;
		if(pNode==null){
			return null;
		}
		//表头
		if(pNode.key.hashCode()==hashcode&&(key==pNode.key || key.equals(pNode.key))){
			V value=pNode.value;
			tables[index]=pNode.next;//删除头节点
			return value;
		}
		//首先查找是否已经存在key
		while(pNode.next!=null){
			//当key的哈希值和真实值相等时
			if(pNode.next.key.hashCode()==hashcode&&(key==pNode.next.key || key.equals(pNode.next.key))){
				V value=pNode.value;
				pNode.next=pNode.next.next;//删除该节点
				return value;
			}
			pNode=pNode.next;//链表：遍历下一个值
		}
		return null;
	}
	
	public void print(){
		for(int i=0;i<tables.length;i++){
			MyEntry<K, V> entry=tables[i];
			if(entry!=null){
				while(entry!=null){
					System.out.println("key="+entry.key+",value="+entry.value);
					entry=entry.next;
				}
			}
		}
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		MyHashMap<String, String> map=new MyHashMap<String, String>();
		for(int i=0;i<100;i++){
			map.put("stu"+i, ""+i);
		}
		for(int i=0;i<20;i++){
			map.remove("stu"+i);
		}
		map.print();
	}
}
