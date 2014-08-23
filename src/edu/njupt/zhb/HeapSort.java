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
	 * ���ѵ���
	 * ��data���з�ΧΪ[i~high]��Ԫ�ص���Ϊ
	 * ��iΪ������������Ϊ����
	 * @param data
	 * @param i
	 * @param high
	 */
	public static void maxHeapify(int []data,int i,int high){
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
			//���ڽ������������������������ѣ�������������ʹ��������Ϊ����
			maxHeapify(data,largest,high);
		}
	}
	/**
	 * ������
	 * 1.������
	 * 2.��������е����ֵ
	 * @param data
	 */
	public static void myHeapSort(int []data){
		int n=data.length;
		//�����ѣ�����n/2���Ժ��Ԫ�ؿ϶���Ҷ�ӽڵ㣬�ɿ�Ϊ��СΪ1������
		//��˴����һ��Ҷ�ӽڵ�����ǰ����
		//���������data[0]Ϊ���ڵ������
		for(int i=n/2-1;i>=0;i--){
			maxHeapify(data,i,n-1);
		}
		//��ʱ��data��һ��data[0]Ϊ���ڵ������
		//�𲽽�data[0]�����һ��Ԫ�ؽ�����Ȼ���ٽ�0~n-2����Ϊ����
		//�൱���𲽽��ѵ����Ԫ�طŵ��������Ĺ���
		for(int i=n-1;i>=1;i--){
			int temp=data[0];
			data[0]=data[i];
			data[i]=temp;
			maxHeapify(data,0,i-1);
		}
	}
}
