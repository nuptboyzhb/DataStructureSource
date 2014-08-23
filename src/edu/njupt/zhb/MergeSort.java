/*
 * $filename: MergeSort.java,v $
 * $Date: 2014-3-28  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-28  Nanjing,njupt,China
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data={2,5,78,23,56,9,10};
		mergeSort(data,0,data.length-1);
		for(int e:data){
			System.out.println(e);
		}
	}
	
//	public static int[] mergeSort(int []data,int low,int high){
//		if(low>=high){
//			int []temp={data[low]};
//			return temp;
//		}
//		int middle=(low+high)/2;
//		int []left=mergeSort(data, low, middle);
//		int []right=mergeSort(data, middle+1, high);
//		return merge(left,right);
//	}
//
//	private static int[] merge(int[] left, int[] right) {
//		// TODO Auto-generated method stub
//		int []result=new int[left.length+right.length];
//		int pa=0,pb=0,pc=0;
//		while(pa<left.length&&pb<right.length){
//			if(left[pa]<right[pb]){
//				result[pc++]=left[pa++];
//			}else {
//				result[pc++]=right[pb++];
//			}
//		}
//		while(pa<left.length){
//			result[pc++]=left[pa++];
//		}
//		while(pb<right.length){
//			result[pc++]=right[pb++];
//		}
//		return result;
//	}
	
	public static void mergeSort(int []data,int low,int high){
		if(low<high){
			int middle=(low+high)/2;
			mergeSort(data, low, middle);
			mergeSort(data, middle+1, high);
			merge(data,low,middle,high);
		}
	}
	/**
	 * ��data�����е�low~middle��middle+1~high
	 * �������ݺϲ�
	 * @param data ����
	 * @param low ��ʼλ��
	 * @param middle ��һ�εĽ���λ��
	 * @param high �ڶ��εĽ���λ��
	 * @return
	 */
	private static void merge(int[] data,int low,int middle,int high) {
		// TODO Auto-generated method stub
		int [] result=new int[high-low+1];
		int pa=low;
		int pb=middle+1;
		int pc=0;
		while(pa<=middle&&pb<=high){
			if(data[pa]<data[pb]){
				result[pc++]=data[pa++];
			}else {
				result[pc++]=data[pb++];
			}
		}
		while(pa<=middle){
			result[pc++]=data[pa++];
		}
		while(pb<=high){
			result[pc++]=data[pb++];
		}
		for(int i=0;i<result.length;i++){
			data[low+i]=result[i];
		}
	}
}
