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
	 * ���ҵڶ����ֵ
	 * ʱ�临�Ӷ�O(n)
	 * �ռ临�Ӷ�O(1)
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
		System.out.println("�����ڵڶ����ֵ");
	}
	/**
	 * ����data�е�����ǰK��ֵ
	 * @param data
	 * @param k
	 */
	public static void findTopK(int []data,int k){
		if(k>=data.length){
			return;
		}
		int n=data.length;
		for(int i=n/2-1;i>=0;i--){//���ѵ�ʱ�临�Ӷ�ΪO(n)
			maxHeapify(data,i,n-1);
		}
		for(int i=n-1;i>=n-k;i--){//ֻ��Ҫ����k�μ���k*log(n)
			System.out.println(data[0]);
			int temp=data[0];
			data[0]=data[i];
			data[i]=temp;
			maxHeapify(data,0,i-1);
		}
	}
	/**
	 * ����topK
	 * ˼·��resultΪ���topK�����飬���Ƚ�data�е�ǰK��Ԫ�ظ��Ƶ�result��
	 * ��result������С�ѣ�ʹresult[0]Ϊ��Сֵ��
	 * ��Σ�����data��ʣ���Ԫ�أ����data[i]����result[0],��ô����data[i]����result[0]
	 * Ȼ������ѣ�ʹresult[0]��Ϊ��Сֵ�����α�������
	 * �ŵ㣺��data�ܴ�ʱ���޷���dataֱ�Ӷ��뵽�ڴ�ʱ���ø÷�ʽ�ܺ��ʣ�
	 * ʱ�临�Ӷȣ�O(K)+O(K)+O(n*logK)
	 * @param data
	 * @param result
	 */
	public static void findTopK(int []data,int []result){
		if(result.length>=data.length){
			return;
		}
		for(int i=0;i<result.length;i++){//��ʼ��result O(K)
			result[i]=data[i];
		}
		for(int i=result.length/2-1;i>=0;i--){//��result���齨�� O(K)
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
	 * ��С�ѵ���
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
	 * �ѵ���
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
