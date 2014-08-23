/*
 * $filename: MyArrayStack.java,v $
 * $Date: 2014-3-11  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-11  Nanjing,njupt,China
 */
/**
 * 使用数组方式实现栈
 * @author Administrator
 *
 */
public class MyArrayStack {
	final int INIT_LEN = 10;//初始化长度
	final int INCREAMENT_LEN = 20;//存储空间分配增量
	private int top;
	private Object []elements;//用于保存栈中的元素
	public MyArrayStack(){
		top=-1;
		elements = new Object[INIT_LEN];
	}
	/**
	 * 入栈
	 * @param object
	 * @return
	 */
	public boolean push(Object object){
		if(top+1>=elements.length){//扩充空间
			Object [] temp = new Object[elements.length+INCREAMENT_LEN];
			for(int i=0;i<elements.length;i++){
				temp[i]=elements[i];
			}
			elements = temp;
		}
		elements[++top]=object;
		return true;
	}
	/**
	 * 出栈
	 * @return
	 */
	public Object pop(){
		if(top==-1){
			return null;
		}
		return elements[top--];
	}
	/**
	 * 栈的大小
	 * @return
	 */
	public int getSize(){
		return top+1;
	}
	
	public Object peek(){
		return elements[top];
	}
	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		MyArrayStack arrayStack = new MyArrayStack();
		for(int i=0;i<30;i++){
			arrayStack.push("--"+i);
		}
		while(!arrayStack.isEmpty()){
			System.out.println((String)arrayStack.pop());
		}
	}
}
