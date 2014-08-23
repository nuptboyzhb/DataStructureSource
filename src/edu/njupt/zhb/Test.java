/*
 * $filename: Test.java,v $
 * $Date: 2014-3-12  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-12  Nanjing,njupt,China
 */
public class Test {
	public static Stack stack;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//displaySubstring("abcdefg");
//		test();

//		Stack<String> q=new Stack<String>();
//		Stack<String> stk=new Stack<String>();
//		Stack<String> output=new Stack<String>();
//		for(int i=0;i<5;i++){
//			q.push(i+"");
//		}
//		allPopSeq(q, stk, output);
//		int []b=new int[3];
//		coding(b,2);
		
		//System.out.println(isPopStack("12345","12543"));
		Cantanla("ABCD", new Stack(), "");
	}
	
	public static void displaySubstring(String str){
		for(int k=0;k<str.length();k++){//���Ʋ���
			for(int i=0;i<str.length()-k;i++){//���ַ�����ɨ��
				for(int j=i;j<i+k+1;j++){//���ɨ�����ʼ�㼰�Ժ��k��Ԫ��
					System.out.print(str.charAt(j));
				}
				System.out.print('\t');
			}
		}
	}
	
	public static void test(){
		brackets(3,0, "");
		System.out.println("-----------------------------");
		brackets(3, 0, 0, new char[3 * 2]);
		
	}
	/**
	 * ����1
	 * @param openStock
	 * @param closeStock
	 * @param s
	 */
	public static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {//�������ŵ����ݺͱ����ŵ���Ŀ��Ϊ��ʱ
            System.out.println(s);
        }
        //���������������0����ô�����һ�������ţ������ŵ���Ŀ-1�������ŵ���Ŀ+1
        if (openStock > 0) {
            brackets(openStock-1, closeStock+1, s + "(");
        }
        //��������ŵ���Ŀ����0����ô�����һ�������ţ������ŵ���Ŀ-1
        if (closeStock > 0) {
            brackets(openStock, closeStock-1, s + ")");
        }
    }
	
	public static void popStackSeq(int pushStock, int popStock) {
        if (pushStock == 0 && popStock == 0) {//�������ŵ����ݺͱ����ŵ���Ŀ��Ϊ��ʱ
            
        }
        //���������������0����ô�����һ�������ţ������ŵ���Ŀ-1�������ŵ���Ŀ+1
        if (pushStock > 0) {
        	popStackSeq(pushStock-1, popStock+1);
        }
        //��������ŵ���Ŀ����0����ô�����һ�������ţ������ŵ���Ŀ-1
        if (popStock > 0) {
        	popStackSeq(pushStock, popStock-1);
        }
    }
	public static void Cantanla(String str1,Stack stack,String seq){
		if(str1.length()==0&&stack.isEmpty()){
			System.out.println(seq);
		}
		if(str1.length()>0){
			Stack temp=stack;
			temp.push(str1.charAt(0)+"");
			Cantanla(str1.substring(1),temp,seq);
		}
		if(!stack.isEmpty()){
			Stack temp=stack;
			seq=seq+temp.pop();
			Cantanla(str1,temp,seq);
		}
	}
	/**
	 * ����2
	 * @param openStock
	 * @param closeStock
	 * @param index
	 * @param arr
	 */
	public static void brackets(int openStock, int closeStock, int index, char[] arr) {
        while (closeStock >= 0) {
            if (openStock > 0) {
                arr[index] = '(';
                brackets(openStock-1, closeStock+1, index+1, arr);
            }
            if (closeStock-- > 0) {
                arr[index++] = ')';
                if (index == arr.length) {
                    System.out.println(arr);
                }
            }
        }
    }
	
//	public static void allPopSeq(Stack<String> q,Stack<String> stk,Stack<String> output){
//		if(q.isEmpty()&&stk.isEmpty()){
//			printStack(output);
//			return;
//		}
//		if(!q.isEmpty()){//��ջ
//			String string=q.pop();
//			stk.push(string);
//			allPopSeq(q, stk, output);
//			stk.pop();
//			q.push(string);
//		}
//		if(!stk.isEmpty()){//��ջ
//			String string=stk.pop();
//			output.push(string);
//			allPopSeq(q, stk, output);
//			output.pop();
//			stk.push(string);
//		}
//		return;
//	}
//	public static void printStack(Stack<String> output) {
//		// TODO Auto-generated method stub
//		Stack<String> tempStack=output;
//		while(!tempStack.isEmpty()){
//			System.out.print(tempStack.pop()+"  ");
//		}
//		System.out.println();
//	}
//	
	public static void coding(int []b,int n){
		if (n==0) {
			b[n]=0;outBn(b);
			b[n]=1;outBn(b);
			return;
		}
		b[n]=0;coding(b, n-1);
		b[n]=1;coding(b, n-1);
	}
	private static void outBn(int[] b) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
		System.out.println();
	}
	/**
	 * �ж��Ƿ��ǳ�ջ����
	 * @param pushStr
	 * @param popStr
	 * @return
	 */
	public static boolean isPopStack(String pushStr,String popStr){
		Stack stack = new Stack();
		int j=0;
		//ģ���ջ��ջ�Ĺ���
		for(int i=0;i<pushStr.length();i++){
			stack.push(new Integer(pushStr.charAt(i)));
			while(!stack.isEmpty()&&((Integer)stack.peek()).intValue()==popStr.charAt(j)){
				stack.pop();
				j++;
			}
		}
		if(j==pushStr.length()){
			return true;
		}
		return false;
	}
}
