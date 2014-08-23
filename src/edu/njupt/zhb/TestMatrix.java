/*
 * $filename: TestMatrix.java,v $
 * $Date: 2014-3-18  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-18  Nanjing,njupt,China
 */
public class TestMatrix {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(4);
	}
	public static void display(int N){
		int []a=new int[N];//先声明一个数组
		for(int i=1;i<=N;i++){//先打印第一行
			if(i%2==1){//第一行中奇数序列的数
				for (int j = 1; j <=i; j++) {
					a[i-1]+=j;
				}
			}else {
				a[i-1]=a[i-2]+1;
			}
			System.out.print(a[i-1]+"\t");
		}
		System.out.println();
		for(int k=2;k<=N;k++){
			if(k%2==0){
				for (int i = 1; i <=N-1; i++) {
					if(i%2==1){
						a[i-1]=a[i]+1;
					}else {
						a[i-1]=a[i]-1;
					}
					System.out.print(a[i-1]+"\t");
				}
				a[N-1]=N*(N+1)/2;
				for(int i=N-1;i>=N-k+1;i--){
					a[N-1]+=i;
				}
				System.out.print(a[N-1]+"\t");
			}else {
				for (int i = 1; i <=N-1; i++) {
					if(i%2==1){
						a[i-1]=a[i]-1;
					}else {
						a[i-1]=a[i]+1;
					}
					System.out.print(a[i-1]+"\t");
				}
				a[N-1]=a[N-1]+1;
				System.out.print(a[N-1]+"\t");
			}
			System.out.println();
		}
	}

}
