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
	 * 冒泡排序 从小到大
	 * 时间复杂度 O(n*n)
	 * @param data
	 */
	public static void bubbleSort(int []data){
		for(int i=0;i<data.length-1;i++){
			for(int j=i+1;j<data.length;j++){//将当前元素i后面的元素，依次与i进行对比
				if(data[j]<data[i]){
					int temp = data[j];
					data[j]=data[i];
					data[i]=temp;
				}
			}
		}
	}
	/**
	 * 简单选择排序 从小到大
	 * 时间复杂度 O(n*n) 与冒泡算法相比，减少了交换次数
	 * @param data
	 */
	public static void selectSort(int []data){
		for(int i=0;i<data.length-1;i++){
			int min = i;//初始化最小值
			for(int j=i+1;j<data.length;j++){//从剩余的data.length-i-1中找到最小的值
				if(data[j]<data[min]){
					min = j;
				}
			}
			if(min!=i){//不是初始值
				int temp = data[min];
				data[min]=data[i];
				data[i]=temp;
			}
		}
	}
	/**
	 * 插入排序 从小到大
	 * 时间复杂度O(n*n)
	 * @param data
	 */
	public static void insertSort(int []data){
		for(int i=1;i<data.length;i++){//可将data[0]自己看成有序的，然后逐步插入后面的数据
			int value = data[i];//取出待插入的值
			int j;
			for(j=i-1;j>=0&&value<data[j];j--){//从当前已经排序好的0~i进行扫描(从后面扫描),寻找待插入的位置
				data[j+1]=data[j];//从后面逐步移动
			}
			data[j+1]=value;//将待插入的值插入到j+1
		}
	}
	/**
	 * 希尔排序 从小到大
	 * 插入排序的改进
	 * @param data
	 */
	public static void shellSort(int []data,int []delta){
		for(int k=0;k<delta.length;k++){
			shellInsert(data, 0, data.length, delta[k]);
		}
	}
	/**
	 * 希尔插入
	 * @param data 待排序数组
	 * @param low  数组中的待排序区域
	 * @param high 
	 * @param deltaK 步长
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
	 * 快速排序
	 * 平均时间复杂度O(n*logn)
	 * @param data 待排序数组
	 * @param low 数组的待排序区域
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
	 * 快速排序中 查找分割线枢纽part，使得右边的全部大于左边的
	 * @param data
	 * @param low
	 * @param high
	 * @return 返回枢纽的下标
	 */
	public static int partition(int []data,int low,int high){
		int value = data[low];//将最左端的值设置为枢纽值
		while(low<high){
			while(low<high&&data[high]>=value){//从右边向左边扫描，查找第一个小于枢纽值的下标
				high--;
			}
			data[low]=data[high];
			while(low<high&&data[low]<=value){//从左边向右边扫描，查找第一个大于枢纽值的下标
				low++;
			}
			data[high]=data[low];
		}
		data[low]=value;
		return low;
	}
	/**
	 * 归并排序
	 * 1.用递归的方式将数组分割成单个数据（单个数据可认为自己有序）
	 * 2.逐步合并已经有序的2个数组
	 * 平均时间复杂度O(n*logn) 最坏O(nlogn)
	 * @param data 待排序的数组
	 * @return
	 */
	public static int[] mergeSort(int []data){
		if(data.length<2){//递归：分割成了一个一个的数据
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
	 * 合并2个有序的数组
	 * @param leftResult 左边的有序数组
	 * @param rightResult 右边的有序数组
	 * @return
	 * result[i]=left (left<right)
	 * result[i]=right (left>=right)
	 */
	public static int [] merge(int []leftResult,int []rightResult){
		int []result = new int[leftResult.length+rightResult.length];//合并数组存放位置
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
	
	public static void mergeSort(int []data,int low,int high){
		if(low<high){
			int middle=(low+high)/2;
			mergeSort(data, low, middle);
			mergeSort(data, middle+1, high);
			merge(data,low,middle,high);
		}
	}
	/**
	 * 将data数组中的low~middle和middle+1~high
	 * 两段数据合并
	 * @param data 数据
	 * @param low 起始位置
	 * @param middle 第一段的结束位置
	 * @param high 第二段的结束位置
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
