/*
 * $filename: TestStackOut.java,v $
 * $Date: 2014-3-17  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
import java.util.Stack;
public class TestStackOut {
	private Stack<String> list = new Stack<String>();//��װ��ջ�����У�Ҳ��ջ��ʵ��
	private Stack<String> stack = new Stack<String>();//����ջ
	private StringBuffer out = new StringBuffer();//�����
	public  void popStackOrder(){//�ݹ鷽��
		if(stack.empty() && list.empty()){//ջ�գ�����Ҳ�գ������
			System.out.println(out);
			return;
		}
		if(!list.empty()){//��listջ�е�Ԫ��ת�Ƶ�stack
			String str = list.pop();
			stack.push(str);
			popStackOrder();
			str = stack.pop();//��ԭ
			list.push(str);//�ָ�ջ
		}
		if(!stack.empty()){//
			String str = stack.pop();//��ջ
			out.append(str);//��¼��ջ˳��
			popStackOrder();
			out.deleteCharAt(out.length()-1);//��ԭ��¼����
			stack.push(str);//��ԭ
		} 
	}
	public void test(){
		//ע�⣬������ջ������123������װ��listջ
		list.push("3");
		list.push("2");
		list.push("1");
		popStackOrder();
	}
	public static void main(String[] args) {
		new TestStackOut().test();
	}
}