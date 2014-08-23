/*
 * $filename: HeapSort.java,v $
 * $Date: 2014-3-17  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-9  Nanjing,njupt,China
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {12,5,6,98,45,2,4,9};
		myHeapSort(a);
		for(int e:a){
			System.out.println(e);
		}
	}

	/**
	 * 最大堆调整
	 * 将data当中范围为[i~high]的元素调整为
	 * 以i为根的子树调整为最大堆
	 * @param data
	 * @param i
	 * @param high
	 */
	public static void maxHeapify(int []data,int i,int high){
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
			//由于交换，可能其子树不满足最大堆，继续向后调整，使其子树成为最大堆
			maxHeapify(data,largest,high);
		}
	}
	/**
	 * 堆排序
	 * 1.建立堆
	 * 2.逐步输出堆中的最大值
	 * @param data
	 */
	public static void myHeapSort(int []data){
		int n=data.length;
		//建立堆，由于n/2及以后的元素肯定是叶子节点，可看为大小为1的最大堆
		//因此从最后一个叶子节点逐步向前调整
		//调整结果：data[0]为根节点的最大堆
		for(int i=n/2-1;i>=0;i--){
			maxHeapify(data,i,n-1);
		}
		//此时，data是一个data[0]为根节点的最大堆
		//逐步将data[0]与最后一个元素交换，然后再将0~n-2调整为最大堆
		//相当于逐步将堆的最大元素放到数组最后的过程
		for(int i=n-1;i>=1;i--){
			int temp=data[0];
			data[0]=data[i];
			data[i]=temp;
			maxHeapify(data,0,i-1);
		}
	}
}
