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
	 * HashMap�����еĽڵ�
	 * @param <K>
	 * @param <V>
	 */
	public class MyEntry<K,V>{
		 public K key;//��
		 public V value;//ֵ
		 public MyEntry<K,V> next;//��һ�����
	}
	
	private MyEntry<K, V> []tables;
	private final int INIT_LEN=50;
	public MyHashMap() {
		tables=new MyEntry[INIT_LEN];
	}
	/**
	 * ��ϣ�����Ĺ��췽��������������
	 * @param hashcode
	 * @return
	 */
	public int indexFor(int hashcode){
		return (hashcode & 0x7fffffff)%tables.length;
	}
	/**
	 * ��ȡ��Ϊkey��ֵ
	 * @param key
	 * @return
	 */
	public V get(K key){
		if(key==null){
			return null;
		}
		int hashcode=key.hashCode();//������Ĺ�ϣֵ
		int index=indexFor(hashcode);//���ݹ�ϣֵ�������ڱ��е��±�index
		MyEntry<K, V> pNode=tables[index];//ȡ����һ���ڵ㣬Ҳ���������ͷ
		//�������в���
		while(pNode!=null){//��������б���
			//��key�Ĺ�ϣֵ����ʵֵ���ʱ����
			if(pNode.key.hashCode()==hashcode&&(key==pNode.key || key.equals(pNode.key))){
				return pNode.value;
			}
			pNode=pNode.next;//����������һ��ֵ
		}
		return null;
	}
	/**
	 * ����ֵ�Է���map����
	 * �����ͻ�ķ���������ַ��
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
		MyEntry<K, V> head=tables[index];//ȡ����һ���ڵ㣬Ҳ���������ͷ
		MyEntry<K, V> pNode=head;
		//���Ȳ����Ƿ��Ѿ�����key
		while(pNode!=null){
			//��key�Ĺ�ϣֵ����ʵֵ���ʱ
			if(pNode.key.hashCode()==hashcode&&(key==pNode.key || key.equals(pNode.key))){
				pNode.value=value;//���µ�ǰkey��ֵ
				return pNode.value;
			}
			pNode=pNode.next;//����������һ��ֵ
		}
		//���û�в��ҵ�������ֵ���뵽����ı�ͷ
		MyEntry<K, V> newNode=new MyEntry<K,V>();
		newNode.key=key;
		newNode.value=value;
		newNode.next=head;
		tables[index]=newNode;
		return value;
	}
	/**
	 * ����keyɾ����Ӧ��ֵ
	 * ˼·���Ȳ��ң���ɾ��
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
		//��ͷ
		if(pNode.key.hashCode()==hashcode&&(key==pNode.key || key.equals(pNode.key))){
			V value=pNode.value;
			tables[index]=pNode.next;//ɾ��ͷ�ڵ�
			return value;
		}
		//���Ȳ����Ƿ��Ѿ�����key
		while(pNode.next!=null){
			//��key�Ĺ�ϣֵ����ʵֵ���ʱ
			if(pNode.next.key.hashCode()==hashcode&&(key==pNode.next.key || key.equals(pNode.next.key))){
				V value=pNode.value;
				pNode.next=pNode.next.next;//ɾ���ýڵ�
				return value;
			}
			pNode=pNode.next;//����������һ��ֵ
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
	 * ����
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
