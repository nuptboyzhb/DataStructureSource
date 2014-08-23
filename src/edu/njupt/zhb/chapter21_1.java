/*
 * $filename: chapter21_1.java,v $
 * $Date: 2014-3-8  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-8  Nanjing,njupt,China
 */
public class chapter21_1 {
	
	public static void main(String[] args) {
		int []a={3,5,8,11};
		int []b={2,6,8,9,11,15,20};
		int []c= new int[a.length+b.length];
		merge(a, b, c);
		for(int e:c){
			System.out.println(e);
		}
	}
	/**
	 * 将a,b合并到c
	 * @param a 有序非递减数组
	 * @param b 有序非递减数组
	 * @param c a,b合并后的数组
	 */
	public static void merge(int []a,int []b,int []c){
		int pa = 0 ,pb=0,pc=0;
		while(pa<a.length&&pb<b.length){
			if(a[pa]<=b[pb]){
				c[pc++]=a[pa++];
			}else {
				c[pc++]=b[pb++];
			}
		}
		while(pa<a.length){
			c[pc++]=a[pa++];
		}
		while(pb<b.length){
			c[pc++]=b[pb++];
		}
	}
}
