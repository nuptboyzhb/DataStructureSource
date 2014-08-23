/*
 * $filename: MyQueue.java,v $
 * $Date: 2014-3-12  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
/*
 *@author: ZhengHaibo
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-12  Nanjing,njupt,China
 */
public interface MyQueue {
	public void add(Object object);//从队列尾部加入一个元素
	public Object remove();//出列，返回队列头部的值，并将其删除
	public int getSize();//获取队列的大小
	public Object peek();//偷看队列的前端元素，但是不出列
	public boolean isEmpty();
}
