/*
 * $filename: MyHuffmanTree.java,v $
 * $Date: 2014-3-15  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.w3c.dom.ls.LSException;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-15  Nanjing,njupt,China
 */
public class MyHuffmanTree {
	public class TreeNode{
		int weight;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
			// TODO Auto-generated constructor stub
		}
	}
	/**
	 * 构建Huffman树
	 * @param nodes
	 * @return
	 */
	public TreeNode buildHuffmanTree(TreeNode []nodes){
		List<TreeNode> list=new LinkedList<TreeNode>();
		for(TreeNode treeNode:nodes){
			insertIntoList(list, treeNode);//将节点按照权值进行排序
		}
		while(list.size()>1){//从有序链表中依次取值
			TreeNode min1=list.remove(list.size()-1);//取出最小值
			TreeNode min2=list.remove(list.size()-1);//取出当前最小值
			TreeNode newTreeNode=new TreeNode();//生成新节点
			newTreeNode.weight=min1.weight+min2.weight;
			newTreeNode.left=min1;
			newTreeNode.right=min2;
			insertIntoList(list, newTreeNode);//将新节点插回有序链表中
		}
		return list.get(0);
	}
	/**
	 * 插入有序表
	 * 根据权值由大到小进行插入排序
	 */
	public void insertIntoList(List<TreeNode> list,TreeNode node){
		if(list.size()==0){
			list.add(node);
			return;
		}
		TreeNode temp;
		for(int i=0;i<list.size();i++){
			if(node.weight>list.get(i).weight){
				temp=list.get(i);
				list.add(i,node);
				return;
			}
		}
		list.add(node);
	}
	/**
	 * 层次遍历打印
	 * @param root
	 */
	public void levelOrder(TreeNode root){
		if(root==null){
			return;
		}
		Queue queue=new LinkedBlockingQueue();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node=(TreeNode)queue.remove();
			System.out.println(node.weight);
			if(node.left!=null){
				queue.add(node.left);
			}
			if (node.right!=null) {
				queue.add(node.right);
			}
		}
	}
	/**
	 * 测试
	 */
	public void test(){
		int []weights={7,4,2,9,15,5};
		TreeNode []nodes=new TreeNode[weights.length];
		for(int i=0;i<weights.length;i++){
			TreeNode node=new TreeNode();
			node.weight=weights[i];
			nodes[i]=node;
		}
		TreeNode root=buildHuffmanTree(nodes);
		levelOrder(root);
	}
	public static void main(String[] args) {
		new MyHuffmanTree().test();
	}
}
