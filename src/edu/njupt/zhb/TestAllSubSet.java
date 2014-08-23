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
		System.out.println("�Ӽ�����Ŀ��"+list.size());
		for(String string:list){
			System.out.println(string);
		}
	}
	/**
	 * �ݹ�˼·:
	 * ���磺���ڼ���{a,b,c}��˵���������������������Ӽ������ǿ��Է������֣�
	 * 1.��ȡ����{b,c}�������Ӽ��������ģ����С��
	 * 2.{b,c}�������Ӽ��ж���ӽ���a
	 * �������ֵĺͣ�ǡ������������{a,b,c}���Ӽ�
	 * @param str ���뼯�ϵ��ַ������硰abc��
	 * @return
	 */
	public static List<String> subSet(String str){
		List<String> list=new ArrayList<String>();
		if(str.length()==0){//�ݹ��������
			list.add(null);//����ַ���Ϊ�գ����һ���ռ���
			return list;
		}
		//��ȡstr�У���ȥ��һ��Ԫ�غ��Ӵ�������Ԫ�ص��Ӽ�
		List<String> subList=subSet(str.substring(1));
		for(String string:subList){//����һ��Ԫ����ӵ������Ӵ���
			if(string==null){//����ǿռ�
				list.add(""+str.charAt(0));
			}else {
				list.add(string+str.charAt(0));
			}
		}
		list.addAll(subList);//�ϲ�����������
		return list;
	}

}
