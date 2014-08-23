/*
 * $filename: MyBinSearchTree.java,v $
 * $Date: 2014-3-15  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-15  Nanjing,njupt,China
 */
/**
 *二叉查找树
 *性质：
 *任意一个根节点：root.left.data<=root.data<=root.right.data
 */
public class MyBinSearchTree {
	/**
	 * 二叉查找树节点
	 */
	public class TreeNode{
		public int data;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int data){
			this.data=data;
		}
	}
	/**
	 * 二叉查找树的插入
	 * 递归方式
	 * @param root
	 * @param node
	 */
	public TreeNode insert(TreeNode root,int data){
		if(root==null){
			root=new TreeNode(data);
			return root;
		}
		if(data<root.data){
			root.left=insert(root.left,data);
		}else if(data>root.data) {
		    root.right=insert(root.right, data);
		}
		return root;
	}
	/**
	 * 循环方式插入
	 * @param root
	 * @param data
	 */
	public void insertLoop(TreeNode root,int data){
		if(root==null){
			root=new TreeNode(data);
			return;
		}
		TreeNode node=root;
		while (true){
			if(data<=node.data){
				if(node.left==null){
					node.left=new TreeNode(data);
					return;
				}
				node=node.left;
			}else{
				if(node.right==null){
					node.right=new TreeNode(data);
					return;
				}
				node=node.right;
			}
		}
	}
	/**
	 * 二叉搜索树的删除
	 * 
	 * @param root
	 * @param data
	 */
	public boolean remove(TreeNode root,int data){
		if(root==null){
			return false;
		}
		TreeNode pNode=root,parentNode=null;
		boolean isLeft=false;//记录子节点与父节点的关系
		while(pNode!=null&&pNode.data!=data){//查找元素data
			parentNode=pNode;//保存父节点
			if(data>pNode.data){
				pNode=pNode.right;
				isLeft=false;
			}else if(data<pNode.data){
				pNode=pNode.left;
				isLeft=true;
			}
		}
		if(pNode==null){
			return false;//当前节点不在树中，返回false
		}
		if(pNode.left==null&&pNode.right==null){//叶子节点，直接删除
			parentNode.left=null;
			parentNode.right=null;
		}
		//如果该节点只有右子树，则直接将其右子树替换它自己
		if(pNode.right!=null&&pNode.left==null){
			if(isLeft){
				parentNode.left=pNode.right;
			}else {
				parentNode.right=pNode.right;
			}
		}
		//如果该节点左子树不为空，那么就要用比该节点大的最小值替换它
		//比data大的最小值(肯定是pNode右子树的最左边的节点)
		if(pNode.left!=null){
			TreeNode ppNode=pNode.right,tempParentNode=pNode;
			if(ppNode.left==null){//ppNode没有左子树，说明ppNode即为要找的值
				pNode.data=ppNode.data;//用找到的值替换该值
				tempParentNode.right=ppNode.right;//先将查找的点取出，将其右子树与该节点的父节点连接
			}else{//ppNode有左子树，即为ppNode的最左边的节点为要查找的值
				while(ppNode.left!=null){//查找到比data大的最小值(肯定是pNode右子树的最左边的节点)
					tempParentNode=ppNode;//保存其父节点
					ppNode=ppNode.left;
				}
				pNode.data=ppNode.data;//用找到的值替换该值
				tempParentNode.left=ppNode.right;//先将查找的点取出，将其右子树与该节点的父节点连接
			}
		}
		return true;
	}
	/**
	 * 中序遍历
	 * 二叉查找树的中序遍历是有序数组
	 * @param root
	 * @param list
	 */
	public void inOrder(TreeNode root,List<TreeNode> list){
		if(root==null){
			return;
		}
		inOrder(root.left, list);
		list.add(root);
		inOrder(root.right, list);
	}
	/**
	 * 查找最小值
	 * @param root
	 * @return
	 */
	public TreeNode findMinNode(TreeNode root){
		if(root==null){
			return null;
		}
		TreeNode pNode=root;
		while (pNode.left!=null) {
			pNode=pNode.left;
		}
		return pNode;
	}
	/**
	 * 查找二叉树的最大值
	 * @param root
	 * @return
	 */
	public TreeNode findMaxNode(TreeNode root){
		if(root==null){
			return null;
		}
		TreeNode pNode=root;
		while (pNode.right!=null) {
			pNode=pNode.right;
		}
		return pNode;
	}
	/**
	 * 判断二叉查找树是否包含某节点（非递归实现）
	 * @param root
	 * @param data
	 * @return
	 */
	public boolean isContains(TreeNode root, int data){
		if(root==null){
			return false;
		}
		TreeNode node=root;
		while(true){
			if(node==null){
				return false;
			}
			if(node.data==data){
				return true;
			}
			if(data<node.data){//如果在左子树上
				node=node.left;
			}else if(data>node.data){
				node=node.right;
			}
		}
	}
	/**
	 * 通过递归方式实现
	 * @param root
	 * @param data
	 * @return
	 */
	public boolean isContains2(TreeNode root,int data){
		if(root==null){
			return false;
		}
		if(root.data==data){
			return true;
		}
		boolean flag=false;
		if(data<root.data){
			flag=isContains(root.left, data);
		}else {
			flag=isContains(root.right, data);
		}
		return flag;
	}
	/**
	 * jiang 
	 * @param root
	 * @return
	 */
	public TreeNode toDbLinkedList(TreeNode root){
		List<TreeNode> list=new LinkedList<TreeNode>();
		inOrder(root, list);
		for(int i=0;i<list.size()-1;i++){
			TreeNode pNode=list.get(i);
			pNode.right=list.get(i+1);
			list.get(i+1).left=pNode;
		}
		list.get(0).left=null;
		list.get(list.size()-1).right=null;
		return list.get(0);
	}
	public void test(){
		int []datas={12,3,4,33,9,23,45,11};
//		TreeNode root=new TreeNode(5);
//		for(int i=0;i<datas.length;i++){
//			insert(root, datas[i]);
//		}
		TreeNode root=new TreeNode(5);
		for(int i=0;i<datas.length;i++){
			insertLoop(root,datas[i]);
		}
		//remove(root,9);
//		List<TreeNode> list = new ArrayList<TreeNode>();
//		inOrder(root, list);
//		for(TreeNode node:list){
//			System.out.print(node.data+" ");
//		}
//		System.out.println(findMaxNode(root).data);
//		for(int i=0;i<datas.length;i++){
//			System.out.println(isContains2(root, datas[i]));
//		}
//		System.out.println(isContains2(root,34));
		TreeNode headNode=toDbLinkedList(root);
		TreeNode pNode=headNode;
		while(pNode!=null){
			System.out.println(pNode.data);
			pNode=pNode.right;
		}
	}
	public static void main(String[] args) {
		new MyBinSearchTree().test();
	}
}
