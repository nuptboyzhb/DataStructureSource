/*
 * $filename: PolynAddAndMultiply.java,v $
 * $Date: 2014-3-10  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.LinkedList;
import java.util.List;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-10  Nanjing,njupt,China
 */
public class PolynAddAndMultiply {
	public class Node{//表示k*x^n
		public int k;//系数
		public int n;//次方数
		public Node(int k,int n) {
			this.k=k;
			this.n=n;
		}
		@Override
		public String toString() {
				// TODO Auto-generated method stub
			return k+"*"+"x^"+n;
		}
	}
	/**
	 * 计算多项式的和
	 * @param polyn1
	 * @param polyn2
	 * @return
	 */
	public List<Node> polynAdd(List<Node> polyn1,List<Node> polyn2){
		List<Node> result = new LinkedList<Node>();
		int p1 = 0;
		int p2 = 0;
		while(p1<polyn1.size()&&p2<polyn2.size()){
			Node node1 = polyn1.get(p1);
			Node node2 = polyn2.get(p2);
			if(node1.n<node2.n){//node1的次方小于node2
				result.add(node1);
				p1++;
			}else if(node1.n==node2.n){//同次幂
				if(node1.k+node2.k!=0){//系数相加不为0
					result.add(new Node(node1.k+node2.k,node1.n));
				}
				p1++;
				p2++;
			}else{//node2的次方小于node1
				result.add(node2);
				p2++;
			}
		}
		while (p1<polyn1.size()) {//如果polyn1还有剩余
			result.add(polyn1.get(p1));
			p1++;
		}
		while (p2<polyn2.size()) {//如果polyn2还有剩余
			result.add(polyn2.get(p2));
			p2++;
		}
		return result;
	}
	/**
	 * 打印多项式
	 * @param list
	 */
	public void display(List<Node> list){
		if(null==list||list.size()<1){
			return;
		}
		System.out.print(list.get(0));
		for(int i=1;i<list.size();i++){
			Node node = list.get(i);
			if(node.k<=0){
				System.out.print(list.get(i));
			}else{
				System.out.print("+"+list.get(i));
			}
		}
		System.out.println("");
	}
	/**
	 * 计算多项式的乘积
	 * 思路：逐个相乘，然后累加
	 * @param polyn1
	 * @param polyn2
	 * @return
	 */
	public List<Node> polynMultiply(List<Node> polyn1,List<Node> polyn2){
		List<Node> resultList = new LinkedList<Node>();
		for(int p1=0;p1<polyn1.size();p1++){//分别取出第一个多项式的每一项
			Node node1 = polyn1.get(p1);
			List<Node> tempList = new LinkedList<Node>();//用于保存第p1项与polyn2各项相乘的结果
			for (int p2 = 0; p2 < polyn2.size(); p2++) {
				Node node2 = polyn2.get(p2);
				Node node = new Node(node1.k*node2.k, node1.n+node2.n);
				tempList.add(node);
			}
			resultList=polynAdd(tempList,resultList);//求和
		}
		return resultList;
	}
	/**
	 * 测试上述的方法
	 */
	public void test(){
		List<Node> polyn1 = new LinkedList<Node>();
		polyn1.add(new Node(2,2));
		polyn1.add(new Node(-100,3));
		polyn1.add(new Node(45,5));
		polyn1.add(new Node(3,20));
		display(polyn1);//2*x^2-100*x^3+45*x^5+3*x^20
		List<Node> polyn2 = new LinkedList<Node>();
		polyn2.add(new Node(-8,2));
		polyn2.add(new Node(7,3));
		polyn2.add(new Node(4,4));
		polyn2.add(new Node(6,18));
		polyn2.add(new Node(7,20));
		display(polyn2);//-8*x^2+7*x^3+4*x^4+6*x^18+7*x^20
		List<Node> result = polynAdd(polyn1, polyn2);
		display(result);//-6*x^2-93*x^3+4*x^4+45*x^5+6*x^18+10*x^20
		List<Node> result2 = polynMultiply(polyn1, polyn2);
		display(result2);
		//-16*x^4+814*x^5-692*x^6-760*x^7+315*x^8+180*x^9+
		//12*x^20-600*x^21-10*x^22-409*x^23+12*x^24+315*x^25+18*x^38+21*x^40
	}
	public static void main(String[] args) {
		new PolynAddAndMultiply().test();
	}
}
