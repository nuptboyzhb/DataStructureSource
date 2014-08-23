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
 *使用二叉堆实现优先队列
 *说明：
 *为了演示优先队列的功能，该优先队列只支持整型的数据
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
	 * 获取堆顶的元素
	 * 最大值
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
	 * 入列
	 * 向堆中添加一个元素，添加后的仍为一个堆
	 * @param data
	 */
	public void add(int data){
		if(size>=datas.length){//扩充数组
			int []temp=new int[datas.length+INIT_LEN];
			for(int i=0;i<datas.length-1;i++){
				temp[i]=datas[i];
			}
			datas=temp;
		}
		datas[size++]=data;//将数据添加到末尾
		for(int i=size/2;i>=0;i--){//建立堆
			maxHeapify(datas, i, size-1);
		}
	}
	/**
	 * 出列
	 * 取出堆中最大的元素,并删除之
	 * @return
	 */
	public int remove(){
		int data=datas[0];//将堆顶数据取出
		for(int i=1;i<size;i++){//平移
			datas[i-1]=datas[i];
		}
		size--;
		for(int i=size/2-1;i>=0;i--){//将新的数组建立堆
			maxHeapify(datas, i, size);
		}
		return data;
	}
	/**
	 * 最大堆调整
	 * 将data当中范围为[i~high]的元素调整为
	 * 以i为根的子树调整为最大堆
	 * @param data
	 * @param i
	 * @param high
	 */
	public void maxHeapify(int []data,int i,int high){
		int left=2*i+1;//左子树
		int right=2*i+2;//右子树
		int largest=i;//定义一个最大值
		if(left<=high&&data[left]>data[i]){
			largest=left;
		}
		if(right<=high&&data[right]>data[largest]){
			largest=right;
		}
		if(largest!=i){//如果最大值不是根节点，将根节点和最大值交换
			int temp=data[i];
			data[i]=data[largest];
			data[largest]=temp;
			maxHeapify(data,largest,high);//继续调节最大值的子树，使其成为最大堆
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
