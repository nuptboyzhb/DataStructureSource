/*
 * $filename: TestStackOut.java,v $
 * $Date: 2014-3-17  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;
import java.util.Stack;
public class TestStackOut {
	private Stack<String> list = new Stack<String>();//待装入栈的序列，也用栈来实现
	private Stack<String> stack = new Stack<String>();//辅助栈
	private StringBuffer out = new StringBuffer();//输出串
	public  void popStackOrder(){//递归方法
		if(stack.empty() && list.empty()){//栈空，序列也空，则输出
			System.out.println(out);
			return;
		}
		if(!list.empty()){//将list栈中的元素转移到stack
			String str = list.pop();
			stack.push(str);
			popStackOrder();
			str = stack.pop();//复原
			list.push(str);//恢复栈
		}
		if(!stack.empty()){//
			String str = stack.pop();//出栈
			out.append(str);//记录出栈顺序
			popStackOrder();
			out.deleteCharAt(out.length()-1);//复原记录次序
			stack.push(str);//复原
		} 
	}
	public void test(){
		//注意，假设入栈序列是123，倒序装入list栈
		list.push("3");
		list.push("2");
		list.push("1");
		popStackOrder();
	}
	public static void main(String[] args) {
		new TestStackOut().test();
	}
}