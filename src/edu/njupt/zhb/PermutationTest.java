/*
 * $filename: PermutationTest.java,v $
 * $Date: 2014-3-25  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-25  Nanjing,njupt,China
 */
public class PermutationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//permutation();
		//List<String> result= permutation("abcd", "");
		//permutation("abcd", "");
		//permutation("abc", "",2);
		Set<String> set = permutation2("alibaba", "");
		System.out.println(set.size());
		for(String str:set){
			System.out.println(str);
		}
	}
	/**
	 * 暴力求解
	 */
	public static void permutation(){
		String string="abc";
		for(int i=0;i<string.length();i++){
			for(int j=0;j<string.length();j++){
				for(int k=0;k<string.length();k++){
					if(i!=j&&i!=k&&k!=j){
						System.out.println(string.charAt(i)+""+string.charAt(j)+""+string.charAt(k));
					}
				}
			}
		}
	}
	/**
	 * 求字符串str的全排列
	 * @param str
	 * @param str2 辅助字符串
	 * @return 全排列的结果
	 */
	public static List<String> permutation(String str,String str2){
		List<String> result= new ArrayList<String>();
		if(str.length()==0){
			result.add(str2);
			System.out.println(str2);
			return result;
		}
		for(int i=0;i<str.length();i++){
			StringBuffer temp=new StringBuffer(str);
			//递归：逐步将str的第i个字符分给str2
			List<String> list = permutation(temp.deleteCharAt(i).toString(),str.charAt(i)+str2);
			result.addAll(list);
		}
		return result;
	}
	/**
	 * 求字符串str的长度为K的全排列
	 * @param str
	 * @param str2
	 * @param k
	 * @return
	 */
	public static List<String> permutation(String str,String str2,int k){
		List<String> result= new ArrayList<String>();
		if(str2.length()==k){
			result.add(str2);
			System.out.println(str2);
			return result;
		}
		for(int i=0;i<str.length();i++){
			StringBuffer temp=new StringBuffer(str);
			//递归：逐步将str的第i个字符分给str2
			List<String> list = permutation(temp.deleteCharAt(i).toString(),str.charAt(i)+str2,k);
			result.addAll(list);
		}
		return result;
	}
	public static Set<String> permutation2(String str,String str2){
		Set<String> result= new LinkedHashSet<String>();
		if(str.length()==0){
			result.add(str2);
			return result;
		}
		for(int i=0;i<str.length();i++){
			StringBuffer temp=new StringBuffer(str);
			//递归：逐步将str的第i个字符分给str2
			Set<String> set = permutation2(temp.deleteCharAt(i).toString(),str.charAt(i)+str2);
			result.addAll(set);
		}
		return result;
	}

}
