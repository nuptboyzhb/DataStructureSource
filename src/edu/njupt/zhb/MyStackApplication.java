/*
 * $filename: MyStackApplication.java,v $
 * $Date: 2014-3-11  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.util.Stack;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-11  Nanjing,njupt,China
 */
/**
 * ʹ��ջ�����Ӧ���㷨
 */
public class MyStackApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MyStackApplication().conversion(100,8);
        System.out.println(new MyStackApplication().isMacth("({[]})(){[}[]"));
        System.out.println(new MyStackApplication().lineEdit("if(@whli##ilr#e(s#*s)"));
        char[][] maze = {{'1','1','1','1','1','1','1','1','1','1'},
				 {'1','0','0','1','1','1','0','0','1','1'},
				 {'1','0','0','1','1','0','0','1','0','1'},
				 {'1','0','0','0','0','0','0','1','0','1'},
				 {'1','0','0','0','0','1','1','0','0','1'},
				 {'1','0','0','1','1','1','0','0','0','1'},
				 {'1','0','0','0','0','1','0','1','0','1'},
				 {'1','0','1','1','0','0','0','1','0','1'},
				 {'1','1','0','0','0','0','1','0','0','1'},
				 {'1','1','1','1','1','1','1','1','1','1'}};
      new MyStackApplication().mazeExit(maze,8,8,1,7);
        
	}
	/**
	 * ��10��������nת��Ϊk����
	 * @param n
	 * @param k
	 */
	public void conversion(int n,final int k){
		Stack stack = new Stack();
		while(n!=0){
			int num = n%k;
			stack.push(num);
			n=n/k;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	/**
	 * �ж��ַ����е������Ƿ�ƥ��
	 * @param string
	 * @return
	 */
	public boolean isMacth(String string){
		char [] str = string.toCharArray();
		Stack stack = new Stack();
		for(int i=0;i<str.length;i++){
			switch (str[i]) {
			case '{':
			case '[':
			case '(':
				stack.push(Integer.valueOf(str[i]));
				break;
			case '}':
				char c1 = (char)((Integer)stack.pop()).intValue();
				if(c1!='{'){
					return false;
				}
				break;
			case ']':
				char c2 = (char)((Integer)stack.pop()).intValue();
				if(c2!='['){
					return false;
				}
				break;
			case ')':
				char c3 = (char)((Integer)stack.pop()).intValue();
				if(c3!='('){
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}
	/**
	 * �����б༭����
	 * ���ͣ����û����ָո�������һ��������ַ����ɲ���һ���˸�#����
	 * ���ڱ�ʾǰһ���ַ���Ч���������֮ǰ��������Բ��ȣ������һ�����з���@������ʾ֮ǰ�ľ���Ч
	 * ���磺
	 * �ַ�����if(@whli##ilr#e(s#*s)
	 * ʵ����Ч��while(*s)
	 * @param string
	 */
	public String lineEdit(String string){
		Stack stack = new Stack();
		char []str = string.toCharArray();
		for(int i=0;i<str.length;i++){
			if(str[i]=='#'){//�������һ��#���͵���һ���ַ�
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else if(str[i]=='@'){//�������һ��@�������ջ
				stack.clear();
			}else {//���ַ�����ջ
				stack.push(Integer.valueOf(str[i]));
			}
		}
		//��stack�е�Ԫ�ط�����һ��ջ�����з�ת
		Stack result = new Stack();
		while(!stack.isEmpty()){
			result.push(stack.pop());
		}
		//��resultջ�е�Ԫ�ط��뵽������
		char []resultStr = new char[result.size()];
		int i=0;
		while(!result.isEmpty()){
			resultStr[i++]=(char)((Integer)result.pop()).intValue();
		}
		return new String(resultStr);
	}
	/**
	 *�����Թ��е�һ����Ԫ�� 
	 */
	public class Cell{
		int x;//��Ԫ��������
		int y;//��Ԫ��������
		boolean isVisited=false;
		char c = ' ';//���ڱ�����ǽ����ͨ·����㵽�յ��·��
		public Cell(int x,int y,boolean isVisited,char c){
			this.x = x;
			this.y = y;
			this.isVisited = isVisited;
			this.c = c;
		}
	}
	/**
	 * ��ӡ�Թ��Ŀ�ͨ·��
	 * @param maze �Թ�����
	 * @param startX ��������
	 * @param startY ���������
	 * @param endX �յ������
	 * @param endY �յ�������
	 */
	public void mazeExit(char [][]maze,int startX,int startY,int endX,int endY){
		Cell [][]cells = createMaze(maze);
		System.out.println("---------------------");
		displayMaze(cells);
		Stack<Cell> stack = new Stack<Cell>();
		Cell startCell = cells[startX][startY];
		Cell endCell = cells[endX][endY];
		startCell.isVisited=true;
		stack.push(startCell);
		while(!stack.isEmpty()){
			Cell currentCell = stack.peek();
			int x = currentCell.x;
			int y = currentCell.y;
			if(currentCell==endCell){//�ҵ����յ�
				while(!stack.isEmpty()){
					Cell cell = stack.pop();//ȡ���յ�
					cell.c='*';//����Ϊ��ͨ·��
					//ջ�г��˺���·��֮�⣬��������δ����̽���ĵ�Ԫ
					while (!stack.isEmpty()&&!isNearByCell(stack.peek(),cell)){//���������ڵģ�ɾ��
						stack.pop();
					}
				}
				System.out.println("---------------------");
				displayMaze(cells);
				return;
			}else{//δ�ҵ��յ�֮ǰ
				boolean isContinue = false;
				if(!cells[x+1][y].isVisited&&cells[x+1][y].c=='0'){//�� (δ�������Ҳ���ǿ)
					cells[x+1][y].isVisited = true;
					stack.push(cells[x+1][y]);
					isContinue = true;
				}
				if(!cells[x][y+1].isVisited&&cells[x][y+1].c=='0'){//�� (δ�������Ҳ���ǿ)
					cells[x][y+1].isVisited = true;
					stack.push(cells[x][y+1]);
					isContinue = true;
				}
				if(!cells[x-1][y].isVisited&&cells[x-1][y].c=='0'){//�� (δ�������Ҳ���ǿ)
					cells[x-1][y].isVisited = true;
					stack.push(cells[x-1][y]);
					isContinue = true;
				}
				if(!cells[x][y-1].isVisited&&cells[x][y-1].c=='0'){//�� (δ�������Ҳ���ǿ)
					cells[x][y-1].isVisited = true;
					stack.push(cells[x][y-1]);
					isContinue = true;
				}
				if(!isContinue){//�ýڵ����Χ�����ܼ��������ˣ�ɾ��֮
					stack.pop();
				}
			}
		}
	}
	/**
	 * �ж��Ƿ����ڽ��ĵ�Ԫ��
	 * @param cell1
	 * @param cell2
	 * @return
	 */
	private boolean isNearByCell(Cell cell1, Cell cell2) {
		// TODO Auto-generated method stub
		if(cell1.x==cell2.x&&Math.abs(cell1.y-cell2.y)==1){//��������
			return true;
		}
		if(cell1.y==cell2.y&&Math.abs(cell1.x-cell2.x)==1){//��������
			return true;
		}
		return false;
	}
	/**
	 * �����Թ����󣬴����Թ���Cell����
	 * @param maze
	 * @return
	 */
	public Cell[][] createMaze(char[][] maze) {
		// TODO Auto-generated method stub
		Cell [][]cells = new Cell[maze.length][];
		for(int i = 0;i<maze.length;i++){
			cells[i] = new Cell[maze[i].length];
			for(int j=0;j<maze[i].length;j++){
				cells[i][j]=new Cell(i, j, false, maze[i][j]);
			}
		}
		return cells;
	}
	/**
	 * ��ӡ�Թ�
	 * @param cells
	 */
	public void displayMaze(Cell [][]cells){
		for(int i=0;i<cells.length;i++){
			for(int j=0;j<cells[i].length;j++){
				System.out.print(cells[i][j].c);
			}
			System.out.println();
		}
	}
	
	
}
