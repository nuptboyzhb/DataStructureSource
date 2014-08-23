/*
 * $filename: TestTopK.java,v $
 * $Date: 2014-3-17  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-17  Nanjing,njupt,China
 */
public class TestTopK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []data={2,5,3,8,56,34,32};
		int []data={99,99,88,86,68,66};
		//findSecondMax(data);
		findTopK(data, 4);
		System.out.println("--------------------");
		int []result=new int[4];
		findTopK(data,result);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	/**
	 * 查找第二大的值
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 * @param data
	 */
	public static void findSecondMax(int []data){
		int maxValue=data[0];
		int secValue=data[0];
		for(int i=1;i<data.length;i++){
			if(data[i]>maxValue){
				secValue=maxValue;
				maxValue=data[i];
			}else if(data[i]>secValue||(secValue==maxValue&&data[i]<secValue)){
				secValue=data[i];
			}
		}
		if(maxValue>secValue){
			System.out.println(secValue);
			return;
		}
		System.out.println("不存在第二大的值");
	}
	/**
	 * 查找data中的最大的前K个值
	 * @param data
	 * @param k
	 */
	public static void findTopK(int []data,int k){
		if(k>=data.length){
			return;
		}
		int n=data.length;
		for(int i=n/2-1;i>=0;i--){//建堆的时间复杂度为O(n)
			maxHeapify(data,i,n-1);
		}
		for(int i=n-1;i>=n-k;i--){//只需要调整k次即可k*log(n)
			System.out.println(data[0]);
			int temp=data[0];
			data[0]=data[i];
			data[i]=temp;
			maxHeapify(data,0,i-1);
		}
	}
	/**
	 * 查找topK
	 * 思路：result为存放topK的数组，首先将data中的前K个元素复制到result中
	 * 对result建立最小堆，使result[0]为最小值。
	 * 其次，遍历data中剩余的元素，如果data[i]大于result[0],那么就用data[i]代替result[0]
	 * 然后调整堆，使result[0]成为最小值。依次遍历结束
	 * 优点：当data很大时，无法将data直接读入到内存时，用该方式很合适！
	 * 时间复杂度：O(K)+O(K)+O(n*logK)
	 * @param data
	 * @param result
	 */
	public static void findTopK(int []data,int []result){
		if(result.length>=data.length){
			return;
		}
		for(int i=0;i<result.length;i++){//初始化result O(K)
			result[i]=data[i];
		}
		for(int i=result.length/2-1;i>=0;i--){//对result数组建堆 O(K)
			minHeapify(result, i, result.length-1);
		}
		for(int i=result.length;i<data.length;i++){//O(n*logK)
			if(data[i]>result[0]){
				result[0]=data[i];
				minHeapify(result,0,result.length-1);
			}
		}
	}
	/**
	 * 最小堆调整
	 * @param data
	 * @param low
	 * @param high
	 */
	private static void minHeapify(int []data,int low,int high){
		int left=2*low+1;
		int right=2*low+2;
		int small=low;
		if(left<=high&&data[left]<data[small]){
			small=left;
		}
		if(right<=high&&data[right]<data[small]){
			small=right;
		}
		if(small!=low){
			int temp=data[low];
			data[low]=data[small];
			data[small]=temp;
			minHeapify(data, small, high);
		}
	}
	/**
	 * 堆调整
	 * @param data
	 * @param low
	 * @param high
	 */
	private static void maxHeapify(int[] data, int low, int high) {
		// TODO Auto-generated method stub
		int left=2*low+1;
		int right=2*low+2;
		int largest=low;
		if(left<=high&&data[left]>data[largest]){
			largest=left;
		}
		if(right<=high&&data[right]>data[largest]){
			largest=right;
		}
		if(largest!=low){
			int temp=data[low];
			data[low]=data[largest];
			data[largest]=temp;
			maxHeapify(data, largest, high);
		}
	}
}
