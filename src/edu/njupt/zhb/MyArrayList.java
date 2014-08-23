/*
 * $filename: MyArrayList.java,v $
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
public class MyArrayList {
	private final int LIST_INIT_LEN = 10;//初始化长度
	private final int LIST_INCREAMENT = 10;//线性表存储空间的增量
	private Object [] objects;
	private int len = 0;//数组的长度
	public MyArrayList(){
		objects = new Object[LIST_INIT_LEN];
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	/**
	 * 
	 * @param object 需要插入的元素
	 * @param i 插入的位置
	 * @return
	 */
	public boolean insert(Object object,int i){
		if(i<0||i>len){//插入的位置下标只能是0~len
			System.out.println("invalide index");
			return false;
		}
		if(len+1>objects.length){//当前空间不够，需要扩充空间
			Object []temp = new Object[objects.length+LIST_INCREAMENT];//申请新的空间
			for(int k=0;k<objects.length;k++){//将原来的数据拷贝到新的数据空间中
				temp[k]=objects[k];
			}
			objects = temp;
		}
		/**
		 * 将第i个之后的数据，依次后移
		 */
		for(int j=len;j>i;j--){
			objects[j]=objects[j-1];
		}
		objects[i]=object;
		len++;
		return true;
	}
	public Object remove(int i){
		if(i<0||i>len-1){//删除的位置下标只能是0~len-1
			System.out.println("invalide index");
			return null;
		}
		Object object = objects[i];
		int j = 0;
		for(j = i;j<len-1;j++){
			objects[j]=objects[j+1];
		}
		len--;
		return object;
	}
	public Object get(int i){
		if(i<0||i>len-1){
			return null;
		}
		return objects[i];
	}
	public Object[] getObjects() {
		return objects;
	}
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	public static void main(String[] args) {
		MyArrayList arrayList = new MyArrayList();
		arrayList.insert("1", 0);
		arrayList.insert("2", 0);
		arrayList.insert("3", 0);
		arrayList.insert("4", 0);
		for(int kk= 0 ;kk<20;kk++){
			arrayList.insert("4"+kk, kk+1);
		}
		arrayList.remove(2);
		Object []objects =arrayList.getObjects();
		for (int i = 0; i < arrayList.getLen(); i++) {
			System.out.println(objects[i]);
		}
	}
}
