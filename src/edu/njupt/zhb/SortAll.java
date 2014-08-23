/*
 * $filename: SortAll.java,v $
 * $Date: 2014-3-9  $
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
public class SortAll {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {12,5,6,98,45,2,4,9};
		//bubbleSort(a);
		//selectSort(a);
		//insertSort(a);
		//int []steps = {5,3,1};
		//shellSort(a,steps);
		//quickSort(a,0,a.length-1);
		
		//int[] b = mergeSort(a);
		myHeapSort(a);
		for(int e:a){
			System.out.println(e);
		}
		
	}
	/**
	 * ð������ ��С����
	 * ʱ�临�Ӷ� O(n*n)
	 * @param data
	 */
	public static void bubbleSort(int []data){
		for(int i=0;i<data.length-1;i++){
			for(int j=i+1;j<data.length;j++){//����ǰԪ��i�����Ԫ�أ�������i���жԱ�
				if(data[j]<data[i]){
					int temp = data[j];
					data[j]=data[i];
					data[i]=temp;
				}
			}
		}
	}
	/**
	 * ��ѡ������ ��С����
	 * ʱ�临�Ӷ� O(n*n) ��ð���㷨��ȣ������˽�������
	 * @param data
	 */
	public static void selectSort(int []data){
		for(int i=0;i<data.length-1;i++){
			int min = i;//��ʼ����Сֵ
			for(int j=i+1;j<data.length;j++){//��ʣ���data.length-i-1���ҵ���С��ֵ
				if(data[j]<data[min]){
					min = j;
				}
			}
			if(min!=i){//���ǳ�ʼֵ
				int temp = data[min];
				data[min]=data[i];
				data[i]=temp;
			}
		}
	}
	/**
	 * �������� ��С����
	 * ʱ�临�Ӷ�O(n*n)
	 * @param data
	 */
	public static void insertSort(int []data){
		for(int i=1;i<data.length;i++){//�ɽ�data[0]�Լ���������ģ�Ȼ���𲽲�����������
			int value = data[i];//ȡ���������ֵ
			int j;
			for(j=i-1;j>=0&&value<data[j];j--){//�ӵ�ǰ�Ѿ�����õ�0~i����ɨ��(�Ӻ���ɨ��),Ѱ�Ҵ������λ��
				data[j+1]=data[j];//�Ӻ������ƶ�
			}
			data[j+1]=value;//���������ֵ���뵽j+1
		}
	}
	/**
	 * ϣ������ ��С����
	 * ��������ĸĽ�
	 * @param data
	 */
	public static void shellSort(int []data,int []delta){
		for(int k=0;k<delta.length;k++){
			shellInsert(data, 0, data.length, delta[k]);
		}
	}
	/**
	 * ϣ������
	 * @param data ����������
	 * @param low  �����еĴ���������
	 * @param high 
	 * @param deltaK ����
	 */
	public static void shellInsert(int []data,int low,int high,int deltaK){
		for(int i=low+deltaK;i<high;i++){
			int value = data[i];
			int j;
			for(j=i-deltaK;j>=low&&value<data[j];j=j-deltaK){
				data[j+deltaK]=data[j];
			}
			data[j+deltaK] = value;
		}
	}
	/**
	 * ��������
	 * ƽ��ʱ�临�Ӷ�O(n*logn)
	 * @param data ����������
	 * @param low ����Ĵ���������
	 * @param high
	 */
	public static void quickSort(int []data,int low,int high){
		if(low<high){
			int partIndex = partition(data,low,high);
			quickSort(data, low, partIndex-1);
			quickSort(data, partIndex+1, high);
		}
	}
	/**
	 * ���������� ���ҷָ�����Ŧpart��ʹ���ұߵ�ȫ��������ߵ�
	 * @param data
	 * @param low
	 * @param high
	 * @return ������Ŧ���±�
	 */
	public static int partition(int []data,int low,int high){
		int value = data[low];//������˵�ֵ����Ϊ��Ŧֵ
		while(low<high){
			while(low<high&&data[high]>=value){//���ұ������ɨ�裬���ҵ�һ��С����Ŧֵ���±�
				high--;
			}
			data[low]=data[high];
			while(low<high&&data[low]<=value){//��������ұ�ɨ�裬���ҵ�һ��������Ŧֵ���±�
				low++;
			}
			data[high]=data[low];
		}
		data[low]=value;
		return low;
	}
	/**
	 * �鲢����
	 * 1.�õݹ�ķ�ʽ������ָ�ɵ������ݣ��������ݿ���Ϊ�Լ�����
	 * 2.�𲽺ϲ��Ѿ������2������
	 * ƽ��ʱ�临�Ӷ�O(n*logn) �O(nlogn)
	 * @param data �����������
	 * @return
	 */
	public static int[] mergeSort(int []data){
		if(data.length<2){//�ݹ飺�ָ����һ��һ��������
			return data;
		}
		int middle = data.length/2;
		int []leftData = new int [middle];
		int []rightData = new int[data.length-middle];
		System.arraycopy(data, 0, leftData, 0, middle);
		System.arraycopy(data, middle, rightData, 0, rightData.length);
		int []leftResult = mergeSort(leftData);
		int []rightResult = mergeSort(rightData);
		return merge(leftResult,rightResult);
	}
	/**
	 * �ϲ�2�����������
	 * @param leftResult ��ߵ���������
	 * @param rightResult �ұߵ���������
	 * @return
	 * result[i]=left (left<right)
	 * result[i]=right (left>=right)
	 */
	public static int [] merge(int []leftResult,int []rightResult){
		int []result = new int[leftResult.length+rightResult.length];//�ϲ�������λ��
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		while(leftIndex<leftResult.length&&rightIndex<rightResult.length){
			if(leftResult[leftIndex]<rightResult[rightIndex]){
				result[resultIndex++]=leftResult[leftIndex++];
			}else {
				result[resultIndex++]=rightResult[rightIndex++];
			}
		}
		while(leftIndex<leftResult.length){
			result[resultIndex++]=leftResult[leftIndex++];
		}
		while(rightIndex<rightResult.length){
			result[resultIndex++]=rightResult[rightIndex++];
		}
		return result;
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
