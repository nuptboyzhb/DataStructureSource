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
	public void add(Object object);//�Ӷ���β������һ��Ԫ��
	public Object remove();//���У����ض���ͷ����ֵ��������ɾ��
	public int getSize();//��ȡ���еĴ�С
	public Object peek();//͵�����е�ǰ��Ԫ�أ����ǲ�����
	public boolean isEmpty();
}
