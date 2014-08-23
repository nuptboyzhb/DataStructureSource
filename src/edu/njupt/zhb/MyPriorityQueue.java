/*
 * $filename: MyPriorityQueue.java,v $
 * $Date: 2014-3-15  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-15  Nanjing,njupt,China
 */
/**
 *ʹ�ö����ʵ�����ȶ���
 *˵����
 *Ϊ����ʾ���ȶ��еĹ��ܣ������ȶ���ֻ֧�����͵�����
 */
public class MyPriorityQueue {
	final int INIT_LEN=10;
	int size;
	int datas[];
	public MyPriorityQueue(){
		datas=new int[INIT_LEN];
		size=0;
	}
	public boolean isEmpty(){
		return size<=0;
	}
	/**
	 * ��ȡ�Ѷ���Ԫ��
	 * ���ֵ
	 * @return
	 */
	public int peek(){
		if(datas.length<1){
			System.out.println("ERROR");
			return -1;
		}
		return datas[0];
	}
	/**
	 * ����
	 * ��������һ��Ԫ�أ���Ӻ����Ϊһ����
	 * @param data
	 */
	public void add(int data){
		if(size>=datas.length){//��������
			int []temp=new int[datas.length+INIT_LEN];
			for(int i=0;i<datas.length-1;i++){
				temp[i]=datas[i];
			}
			datas=temp;
		}
		datas[size++]=data;//��������ӵ�ĩβ
		for(int i=size/2;i>=0;i--){//������
			maxHeapify(datas, i, size-1);
		}
	}
	/**
	 * ����
	 * ȡ����������Ԫ��,��ɾ��֮
	 * @return
	 */
	public int remove(){
		int data=datas[0];//���Ѷ�����ȡ��
		for(int i=1;i<size;i++){//ƽ��
			datas[i-1]=datas[i];
		}
		size--;
		for(int i=size/2-1;i>=0;i--){//���µ����齨����
			maxHeapify(datas, i, size);
		}
		return data;
	}
	/**
	 * ���ѵ���
	 * ��data���з�ΧΪ[i~high]��Ԫ�ص���Ϊ
	 * ��iΪ������������Ϊ����
	 * @param data
	 * @param i
	 * @param high
	 */
	public void maxHeapify(int []data,int i,int high){
		int left=2*i+1;//������
		int right=2*i+2;//������
		int largest=i;//����һ�����ֵ
		if(left<=high&&data[left]>data[i]){
			largest=left;
		}
		if(right<=high&&data[right]>data[largest]){
			largest=right;
		}
		if(largest!=i){//������ֵ���Ǹ��ڵ㣬�����ڵ�����ֵ����
			int temp=data[i];
			data[i]=data[largest];
			data[largest]=temp;
			maxHeapify(data,largest,high);//�����������ֵ��������ʹ���Ϊ����
		}
	}
	
	public static void main(String[] args) {
		MyPriorityQueue queue=new MyPriorityQueue();
		int []datas={2,54,23,56,8,65,3};
		for(int data:datas){
			queue.add(data);
		}
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
	}
	
}
