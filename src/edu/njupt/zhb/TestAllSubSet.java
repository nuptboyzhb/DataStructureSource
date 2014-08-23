/*
 * $filename: TestAllSubSet.java,v $
 * $Date: 2014-4-8  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.ArrayList;
import java.util.List;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-4-8  Nanjing,njupt,China
 */
public class TestAllSubSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = subSet("abcde");
		System.out.println("子集的数目："+list.size());
		for(String string:list){
			System.out.println(string);
		}
	}
	/**
	 * 递归思路:
	 * 例如：对于集合{a,b,c}来说，我们如果获得它的所有子集，我们可以分两部分：
	 * 1.获取集合{b,c}的所有子集（问题规模见减小）
	 * 2.{b,c}的所有子集中都添加进入a
	 * 这两部分的和，恰好是整个集合{a,b,c}的子集
	 * @param str 输入集合的字符串，如“abc”
	 * @return
	 */
	public static List<String> subSet(String str){
		List<String> list=new ArrayList<String>();
		if(str.length()==0){//递归结束条件
			list.add(null);//如果字符串为空，添加一个空集合
			return list;
		}
		//获取str中，除去第一个元素后，子串的所有元素的子集
		List<String> subList=subSet(str.substring(1));
		for(String string:subList){//将第一个元素添加到所有子串中
			if(string==null){//如果是空集
				list.add(""+str.charAt(0));
			}else {
				list.add(string+str.charAt(0));
			}
		}
		list.addAll(subList);//合并这两个部分
		return list;
	}

}
