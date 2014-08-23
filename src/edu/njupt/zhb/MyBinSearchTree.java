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
 *���������
 *���ʣ�
 *����һ�����ڵ㣺root.left.data<=root.data<=root.right.data
 */
public class MyBinSearchTree {
	/**
	 * ����������ڵ�
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
	 * ����������Ĳ���
	 * �ݹ鷽ʽ
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
	 * ѭ����ʽ����
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
	 * ������������ɾ��
	 * 
	 * @param root
	 * @param data
	 */
	public boolean remove(TreeNode root,int data){
		if(root==null){
			return false;
		}
		TreeNode pNode=root,parentNode=null;
		boolean isLeft=false;//��¼�ӽڵ��븸�ڵ�Ĺ�ϵ
		while(pNode!=null&&pNode.data!=data){//����Ԫ��data
			parentNode=pNode;//���游�ڵ�
			if(data>pNode.data){
				pNode=pNode.right;
				isLeft=false;
			}else if(data<pNode.data){
				pNode=pNode.left;
				isLeft=true;
			}
		}
		if(pNode==null){
			return false;//��ǰ�ڵ㲻�����У�����false
		}
		if(pNode.left==null&&pNode.right==null){//Ҷ�ӽڵ㣬ֱ��ɾ��
			parentNode.left=null;
			parentNode.right=null;
		}
		//����ýڵ�ֻ������������ֱ�ӽ����������滻���Լ�
		if(pNode.right!=null&&pNode.left==null){
			if(isLeft){
				parentNode.left=pNode.right;
			}else {
				parentNode.right=pNode.right;
			}
		}
		//����ýڵ���������Ϊ�գ���ô��Ҫ�ñȸýڵ�����Сֵ�滻��
		//��data�����Сֵ(�϶���pNode������������ߵĽڵ�)
		if(pNode.left!=null){
			TreeNode ppNode=pNode.right,tempParentNode=pNode;
			if(ppNode.left==null){//ppNodeû����������˵��ppNode��ΪҪ�ҵ�ֵ
				pNode.data=ppNode.data;//���ҵ���ֵ�滻��ֵ
				tempParentNode.right=ppNode.right;//�Ƚ����ҵĵ�ȡ����������������ýڵ�ĸ��ڵ�����
			}else{//ppNode������������ΪppNode������ߵĽڵ�ΪҪ���ҵ�ֵ
				while(ppNode.left!=null){//���ҵ���data�����Сֵ(�϶���pNode������������ߵĽڵ�)
					tempParentNode=ppNode;//�����丸�ڵ�
					ppNode=ppNode.left;
				}
				pNode.data=ppNode.data;//���ҵ���ֵ�滻��ֵ
				tempParentNode.left=ppNode.right;//�Ƚ����ҵĵ�ȡ����������������ýڵ�ĸ��ڵ�����
			}
		}
		return true;
	}
	/**
	 * �������
	 * ����������������������������
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
	 * ������Сֵ
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
	 * ���Ҷ����������ֵ
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
	 * �ж϶���������Ƿ����ĳ�ڵ㣨�ǵݹ�ʵ�֣�
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
			if(data<node.data){//�������������
				node=node.left;
			}else if(data>node.data){
				node=node.right;
			}
		}
	}
	/**
	 * ͨ���ݹ鷽ʽʵ��
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
