package edu.njupt.zhb;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-13  Nanjing,njupt,China
 */
/**
 * ��������ʵ��
 */
public class MyBinaryTree {
	/**
	 * �������Ľڵ�
	 */
	public class TreeNode{
		Object data;//������
		TreeNode left;//������
		TreeNode right;//������
	}
	public MyBinaryTree(){
		
	}
	/**
	 * ��������ĵݹ�ʵ��
	 * ��->������->������
	 * @param root
	 * @param list
	 */
	public void preOrderTraverse(TreeNode root,List list){
		if(root==null){
			return;
		}
		list.add(root.data);
		preOrderTraverse(root.left, list);
		preOrderTraverse(root.right, list);
	}
	/**
	 * ��������ķǵݹ�ʵ�֣�������ջ
	 * @param root
	 * @param list
	 */
	public void preOrderLoop(TreeNode root,List list){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			list.add(node.data);
			if(node.right!=null){//�����������Ϊ�գ���ջ
				stack.push(node.right);
			}
			if(node.left!=null){////�����������Ϊ�գ���ջ
				stack.push(node.left);
			}
		}
	}
	/**
	 * ��������ĵݹ�ʵ��
	 * ������->��->������
	 * @param root
	 * @param list
	 */
	public void inOrderTraverse(TreeNode root,List list){
		if(root==null){
			return;
		}
		inOrderTraverse(root.left, list);
		list.add(root.data);
		inOrderTraverse(root.right, list);
	}
	/**
	 * ��������ķǵݹ�ʵ��(˫ջ)
	 * ������->��->������
	 * @param root
	 * @param list
	 */
	public void inOrderLoop(TreeNode root,List list){
		if(root==null){
			return ;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode=root;
		while(pNode!=null||!stack.isEmpty()){
			while(pNode!=null){//һֱ���ýڵ����������ջ
				stack.push(pNode);
				pNode=pNode.left;
			}
			if(!stack.isEmpty()){
				pNode=stack.pop();
				list.add(pNode.data);
				pNode=pNode.right;//ת��������������һ��ѭ��
			}
		}
	}
	/**
	 * ��������ĵݹ�ʵ��
	 * ������->������->��
	 * @param root
	 * @param list
	 */
	public void postOrderTraverse(TreeNode root,List list){
		if(root==null){
			return;
		}
		postOrderTraverse(root.left, list);
		postOrderTraverse(root.right, list);
		list.add(root.data);
	}
	public void postOrderTraverse2(TreeNode root,List<TreeNode> list){
		if(root==null){
			return;
		}
		postOrderTraverse2(root.left, list);
		postOrderTraverse2(root.right, list);
		list.add(root);
	}
	/**
	 * ������еķǵݹ鷽ʽ��˫ջ����
	 * �������Ϊ��������->������->���ڵ�
	 * Ȼ��������֪����ǰ������ķǵݹ鷽ʽ�ǳ�����ʵ�֡����ǵ������
	 * ���ڵ�->������->�������ķ�ʽ���Ǻ�������������ڵ�->������->��������
	 * �ǵݹ�ʵ�ֺ�ǰ������ķǵݹ�ʵ�ַǳ����ƣ�ֻ�ǵߵ�һ������������˳��
	 * @param root
	 * @param list
	 */
	public void postOrderLoop(TreeNode root,List list){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();//���ڱ���
		Stack<TreeNode> output = new Stack<TreeNode>();//���ڱ�������
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			output.push(treeNode);
			if(treeNode.left!=null){//�Ƚ���������ջ
				stack.push(treeNode.left);
			}
			if(treeNode.right!=null){//�ٽ���������ջ
				stack.push(treeNode.right);
			}
		}
		/**
		 * ��outputջ�е����ݷ���list�м�������˷�ת
		 */
		while(!output.isEmpty()){
			list.add(output.pop().data);
		}
	}
//	public void postOrderLoop(TreeNode root,List list){
//		if(root==null){
//			return;
//		}
//		TreeNode pNode=root;
//		Stack<TreeNode> stack=new Stack<TreeNode>();
//		while(pNode!=null||!stack.isEmpty()){
//			while(pNode!=null){//���Ҳ�������
//				stack.push(pNode);//�Ƚ����ڵ���ջ
//				if(pNode.left!=null){
//					pNode=pNode.left;
//				}else {
//					pNode=pNode.right;
//				}
//			}
//			if(!stack.isEmpty()){
//				pNode=stack.pop();//ȡ��ջ�����ڵ㣬����֮
//				list.add(pNode.data);
//			}
//			//��������ʱ��˵��ջ�����ڵ��������Ѿ����ʣ�Ӧ��ջ����֮
//			while(!stack.isEmpty()&&stack.peek().right.equals(pNode)){
//				pNode=stack.pop();
//				list.add(pNode.data);
//			}
//			//ת��ջ�����ڵ��������������������
//			if(!stack.isEmpty()){
//				pNode=stack.peek().right;
//			}else {
//				pNode=null;
//			}
//		}
//	}
	/**
	 * ��α���
	 * @param root
	 * @param list
	 */
	public void levelOrderTraverse(TreeNode root,List list){
		if(root==null){
			return;
		}
		Queue queue = new LinkedBlockingDeque();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = (TreeNode)queue.remove();
			list.add(node.data);
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
	/**
	 * ��ȡ�������нڵ�ĸ���
	 * �ݹ�ⷨ��
	 * ��1�����������Ϊ�գ��ڵ����Ϊ0
	 * ��2�������������Ϊ�գ��������ڵ���� = �������ڵ���� + �������ڵ���� + 1
	 * @param root
	 * @return
	 */
	public int getNodeNum(TreeNode root){
		if(root==null){
			return 0;
		}
		return getNodeNum(root.left)+getNodeNum(root.right)+1;
	}
	
	/**
	 * ���������K��Ľڵ����
	 * �ݹ�ⷨ��
	 * ��1�����������Ϊ�ջ���k<1����0
	 * ��2�������������Ϊ�ղ���k==1������1
	 * ��3�������������Ϊ����k>1������k-1�����������Ľڵ�������������ڵ����֮��
	 * @param root
	 * @param k
	 * @return
	 */
	public int getKthNodeNum(TreeNode root,int k){//*
		if(root==null||k<1){
			return 0;
		}
		if(k==1){
			return 1;
		}
		int leftNum = getKthNodeNum(root.left, k-1);
		int rightNum = getKthNodeNum(root.right, k-1);
		return leftNum+rightNum;
	}
	/**
	 * ���������Ҷ�ӽڵ�ĸ���
	 * �ݹ�ⷨ��
	 * ��1�����������Ϊ�գ�����0
	 * ��2�������������Ϊ������������Ϊ�գ�����1
	 * ��3�������������Ϊ�գ�������������ͬʱΪ�գ�������������Ҷ�ӽڵ����������������Ҷ�ӽڵ����
	 * @param root
	 * @return
	 */
	public int getLeafNodeNum(TreeNode root){
		if(root==null){
			return 0;
		}
		if(root.left==null&&root.right==null){
			return 1;
		}
		int leftNum = getLeafNodeNum(root.left);
		int rightNum = getLeafNodeNum(root.right);
		return leftNum+rightNum;
	}
	/**
	 * ��������ľ���
	 * �ݹ�ⷨ��
	 * ��1�����������Ϊ�գ����ؿ�
	 * ��2�������������Ϊ�գ������������������ľ���Ȼ�󽻻���������������
	 * @param root
	 * @return
	 */
	public TreeNode mirrorTree(TreeNode root){
		if(root==null){
			return null;
		}
		TreeNode leftNode = mirrorTree(root.left);
		TreeNode rightNode = mirrorTree(root.right);
		root.left=rightNode;
		root.right=leftNode;
		return root;
	}
	/**
	 * ���������ľ��񣨷ǵݹ鷽ʽ��
	 * ˼·������ǰ������ķǵݹ鷽ʽ�Ľ�
	 * @param root
	 */
	public void mirrorTreeLoop(TreeNode root){
		if(root==null){
			return;
		}
		Stack stack=new Stack();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode treeNode=(TreeNode)stack.pop();
			//������������
			TreeNode temp = treeNode.right;
			treeNode.right=treeNode.left;
			treeNode.left=temp;
			if(treeNode.right!=null){
				stack.push(treeNode.right);
			}
			if(treeNode.left!=null){
				stack.push(treeNode.left);
			}
		}
	}
	/**
	 * ����Ԫ��object���ڵĽڵ�
	 * @param root
	 * @param object
	 * @return
	 */
	public TreeNode searchNode(TreeNode root,Object object){
		if(root==null){
			return null;
		}
		if(root.data.equals(object)){
			return root;
		}
		TreeNode node = searchNode(root.left, object);
		if(node==null){
			node = searchNode(root.right, object);
		}
		return node;
	}
	public boolean isContains(TreeNode root,TreeNode node){
		if(root==null){
			return false;
		}
		if(root==node){
			return true;
		}
		boolean isFound=false;
		isFound=isContains(root.left, node);
		if(!isFound){
			isFound=isContains(root.right, node);
		}
		return isFound;
	}
	/**
	 * �����������
	 * �ݹ�ⷨ��
	 * ��1�����������Ϊ�գ������������Ϊ0
	 * ��2�������������Ϊ�գ������������ = max(��������ȣ� ���������) + 1
	 * @param root
	 * @return
	 */
	public int getTreeDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftDepth=getTreeDepth(root.left);
		int rigthDepth=getTreeDepth(root.right);
		int depth=leftDepth>=rigthDepth?leftDepth+1:rigthDepth+1;
		return depth;
	}
	/**
	 * ��ȡ�������Ŀ��
	 * ��ȵĶ��壺������ÿһ���нڵ��������
	 * @param root
	 * @return
	 */
	public int getTreeWidth(TreeNode root){
		if(root==null){
			return 0;
		}
		int depth=getTreeDepth(root);
		int width=0;
		for(int i=1;i<=depth;i++){
			int temp=getKthNodeNum(root, i);
			if(temp>width){
				width=temp;
			}
		}
		return width;
	}
	/**
	 * �ж϶������ǲ�����ȫ������(��α���)
	 * ���壺
	 * ��������������Ϊh������ h ���⣬
	 * �������� (1��h-1) �Ľ�������ﵽ��������
	 * �� h �����еĽ�㶼��������������ߣ��������ȫ��������
	 * �㷨�жϣ�
	 * ����Σ����ϵ��£������ң�������������
	 * ������һ���ڵ��������Ϊ��ʱ����ýڵ�����������Ϊ�գ�
	 * �Һ�������Ľڵ���������������Ϊ�գ���������ȫ��������
	 * @param root
	 * @return
	 */
	public boolean isCompleteBinaryTree(TreeNode root){
		if (root==null) {
			return false;
		}
		Queue queue = new LinkedBlockingQueue();
		queue.add(root);
		boolean flag=false;//�ж��Ƿ�������������������������Ľڵ�
		while(!queue.isEmpty()){
			TreeNode node = (TreeNode)queue.remove();
			if(flag){//ʣ�µĽڵ�ֻ����Ҷ�ӽڵ�
				if(node.left!=null||node.right!=null){//����Ҷ�ӽڵ�Ļ���ֱ�ӷ���false
					return false;
				}
			}else{
				if(node.left!=null&&node.right!=null){
					queue.add(node.left);
					queue.add(node.right);
				}else if(node.left!=null&&node.right==null){
					queue.add(node.left);
					flag=true;
				}else if(node.left==null&&node.right!=null){
					return false;//�϶�������ȫ������
				}else if(node.left==null&&node.right==null){
					flag=true;
				}
			}
		}
		return true;
	}
	/**
	 * ��ȡ���ڵ㵽����ڵ�node��·�����ݹ飩
	 * ͨ���ݹ�ķ�ʽ��������������Ѱ�ң��������������û�У���ɾ���ýڵ�
	 * ���ߣ��ýڵ�����·���ϵĽڵ�֮һ
	 * @param root
	 * @param node
	 * @param list
	 */
	public boolean getTreePath(TreeNode root,TreeNode node,List list){
		if(root==null){
			return false;
		}
		list.add(root);
		if(root==node){
			return true;
		}
		boolean isFound=false;
		isFound=getTreePath(root.left, node, list);//����������Ѱ��
		if(!isFound){//���������û�ң�����������Ѱ��
			isFound=getTreePath(root.right, node, list);
		}
		if(!isFound){//����������û���ҵ���˵������ڵ�û�У�ɾ��֮,������false
			list.remove(list.size()-1);
			return false;
		}
		return true;
	}
	/**
	 * Ѱ�����������ڵ����͹������Ƚڵ�
	 * ˼·��Ѱ�Ҹ��ڵ㵽node1��·���͵�node2��·��
	 * ����·�����һ����ͬ�Ľڵ㼴Ϊ��͹������Ƚڵ�
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public TreeNode getNearComParentNode(TreeNode root,TreeNode node1,TreeNode node2){
		List<TreeNode> path1=new LinkedList<TreeNode>();
		List<TreeNode> path2=new LinkedList<TreeNode>();
		boolean flag1=getTreePath(root, node1, path1);
		boolean flag2=getTreePath(root, node2, path2);
		if(!flag1||!flag2){//�����нڵ㲻�ڶ�������
			return null;
		}
		int i=0,j=0,index=0;
		//��������·�������һ����ͬ�Ľڵ�
		while (i<path1.size()&&j<path2.size()) {
			if(path1.get(i).equals(path2.get(j))){
				index=i;
			}else{
				break;
			}
			i++;
			j++;
		}
		return path1.get(index);
	}
	/**
	 * Ѱ�����������ڵ����͹������Ƚڵ�
	 * ˼·2�����Ⱥ����������͵Ĺ������Ƚڵ�һ������������ڵ�ĺ���
	 * Ȼ���𲽱�������Ľڵ㣬��һ���Ȱ���node1�ְ���node2�Ľڵ㼴������ڵ�
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public TreeNode getNearComParentNode2(TreeNode root,TreeNode node1,TreeNode node2){
		List<TreeNode> list= new ArrayList<TreeNode>();
		postOrderTraverse2(root, list);//�������
		int flag=0;
		int i=0;
		for(i=0;i<list.size();i++){//���������ڵ�֮�������ֵ
			TreeNode node=list.get(i);
			if(node.equals(node1)||node.equals(node2)){
				flag++;
				if(flag==2){
					break;
				}
			}
		}
		if(flag==2){//�Ѳ鵽�����ڵ㣬����Ľڵ������α�������һ���Ȱ���node1�ְ���node2�Ľڵ㼴��
			for(int j=i;i<list.size();i++){
				TreeNode node=list.get(i);
				if(isContains(node, node1)&&isContains(node, node2)){
					return node;
				}
			}
		}
		return null;
	}
	/**
	 * �ж��Ƿ���ƽ�������
	 * ��1�����������Ϊ�գ������� 
     * ��2�������������Ϊ�գ����������������������AVL��
     * �������������������߶�������1�������棬�������ؼ�
	 * @param root
	 * @return
	 */
	public boolean isAVLTree(TreeNode root){
		if(root==null){
			return true;
		}
		int leftDepth=getTreeDepth(root.left);
		int rightDepth=getTreeDepth(root.right);
		if(Math.abs(leftDepth-rightDepth)>1){
			return false;
		}
		boolean isLeft=isAVLTree(root.left);
		boolean isRight=isAVLTree(root.right);
		return isLeft&&isRight;
	}
	/**
	 * ���������������������ؽ�������
	 * ˼·:�ݹ�
	 * ���磺���������ABDEFC ���������DBEFAC
	 * 1.��ȡ����������ĵ�һ���ڵ㣬Ϊ���ڵ�
	 * 2.���ݸ��ڵ�����������е�λ�ã�����������ָ��2����
	 * 3.������������ָ��ĳ��ȣ������������Ӧ�ָ�
	 * 4.�ݹ鷽ʽ���ؽ���������������
	 * @param perOrder
	 * @param inOrder
	 * @return
	 */
	public TreeNode rebuildTree(List perOrder,List inOrder){
		if(perOrder.size()!=inOrder.size()){//��������
			return null;
		}
		TreeNode root=null;
		if(perOrder.size()>0){
			root=new TreeNode();//�½��ڵ�
			Object perRoot=perOrder.get(0);//ǰ������ĵ�һ���ڵ�Ϊ���ڵ�
			root.data=perRoot;
			int indexInOrder=inOrder.indexOf(perRoot);//���Ҹ��ڵ�������ڵ��λ��
			//���ݸ��ڵ��λ�ã����Ǹ���������ֳ�����������������
			List leftInOrder=inOrder.subList(0,indexInOrder);
			List rightInOrder=inOrder.subList(indexInOrder+1,inOrder.size());
			//����������������ĳ��ȣ����ηָ����Ӧ��ǰ�����
			List leftPerOrder=perOrder.subList(1, leftInOrder.size()+1);
			List rightPerOrder=perOrder.subList(leftInOrder.size()+1,perOrder.size());
			//�ݹ�ķ�ʽ�������ؽ�
			root.left=rebuildTree(leftPerOrder, leftInOrder);
			root.right=rebuildTree(rightPerOrder, rightInOrder);
		}
		return root;
	}
	public void test(){
		TreeNode root=new TreeNode();
		root.data="A";
		TreeNode nodeB=new TreeNode();
		nodeB.data="B";
		TreeNode nodeC=new TreeNode();
		nodeC.data="C";
		TreeNode nodeD=new TreeNode();
		nodeD.data="D";
		TreeNode nodeE=new TreeNode();
		nodeE.data="E";
		TreeNode nodeF=new TreeNode();
		nodeF.data="F";
        //////////////////////���ýڵ�Ĺ�ϵ
		root.left=nodeB;
		root.right=nodeC;
		nodeB.left=nodeD;
		nodeB.right=nodeE;
		nodeE.right=nodeF;
		///////////һ�²���������������ȷ��
		List list = new LinkedList();
//		preOrderTraverse(root, list);
//		preOrderLoop(root,list);
//		inOrderTraverse(root, list);
//		inOrderLoop(root, list);
//		postOrderTraverse(root, list);
//		postOrderLoop(root, list);
//		levelOrderTraverse(root, list);
//		for(Object object:list){
//			System.out.print((String)object+" ");
//		}
//		System.out.println(getKthNodeNum(root, 4));
//		System.out.println(getLeafNodeNum(root));
//		System.out.println(getNodeNum(root));
//		TreeNode treeNode = searchNode(root, "E");
//		System.out.println(treeNode.right.data);//F
//		System.out.println(getTreeDepth(root));
//		TreeNode newRootNode = mirrorTree(root);
//		levelOrderTraverse(newRootNode, list);
//		for(Object object:list){
//		    System.out.print((String)object+" ");
//    	}
//		mirrorTreeLoop(root);
//		levelOrderTraverse(root,list);
//		for(Object object:list){
//		    System.out.print((String)object+" ");
//    	}
//		System.out.println(isCompleteBinaryTree(root));
//		getTreePath(root, nodeC, list);
//		for(Object object:list){
//			System.out.print((String)((TreeNode)object).data+" ");
//		}
//		TreeNode node= getNearComParentNode2(root, nodeE, nodeF);
//		System.out.println(node.data);
//		System.out.println(getTreeWidth(root));
//		System.out.println(isAVLTree(root));
		List perOrderList = new LinkedList();
		List inOrderList = new LinkedList();
		preOrderTraverse(root, perOrderList);
		inOrderTraverse(root, inOrderList);
		TreeNode treeNode=rebuildTree(perOrderList, inOrderList);
		List postOrderList=new LinkedList();
		postOrderTraverse(treeNode, postOrderList);
		for (Object object : postOrderList) {
			System.out.print((String) object + " ");
		}
	}
	public static void main(String[] args) {
		MyBinaryTree myBinaryTree = new MyBinaryTree();
		myBinaryTree.test();
	}
}
