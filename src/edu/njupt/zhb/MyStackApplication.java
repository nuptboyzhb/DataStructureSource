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
 * 使用栈完成相应的算法
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
	 * 将10进制数字n转化为k进制
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
	 * 判断字符串中的括号是否匹配
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
	 * 处理行编辑程序
	 * 解释：当用户发现刚刚输入了一个错误的字符，可补进一个退格“#”，
	 * 用于表示前一个字符无效；如果发现之前输入的难以补救，则插入一个退行符‘@’，表示之前的均无效
	 * 例如：
	 * 字符串：if(@whli##ilr#e(s#*s)
	 * 实际有效：while(*s)
	 * @param string
	 */
	public String lineEdit(String string){
		Stack stack = new Stack();
		char []str = string.toCharArray();
		for(int i=0;i<str.length;i++){
			if(str[i]=='#'){//如果发现一个#，就弹出一个字符
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else if(str[i]=='@'){//如果发现一个@，就清空栈
				stack.clear();
			}else {//将字符加入栈
				stack.push(Integer.valueOf(str[i]));
			}
		}
		//将stack中的元素放入另一个栈，进行反转
		Stack result = new Stack();
		while(!stack.isEmpty()){
			result.push(stack.pop());
		}
		//将result栈中的元素放入到数组中
		char []resultStr = new char[result.size()];
		int i=0;
		while(!result.isEmpty()){
			resultStr[i++]=(char)((Integer)result.pop()).intValue();
		}
		return new String(resultStr);
	}
	/**
	 *保存迷宫中的一个单元格 
	 */
	public class Cell{
		int x;//单元格所在行
		int y;//单元格所在列
		boolean isVisited=false;
		char c = ' ';//用于保存是墙、可通路或起点到终点的路径
		public Cell(int x,int y,boolean isVisited,char c){
			this.x = x;
			this.y = y;
			this.isVisited = isVisited;
			this.c = c;
		}
	}
	/**
	 * 打印迷宫的可通路径
	 * @param maze 迷宫矩阵
	 * @param startX 起点横坐标
	 * @param startY 起点纵坐标
	 * @param endX 终点横坐标
	 * @param endY 终点纵坐标
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
			if(currentCell==endCell){//找到了终点
				while(!stack.isEmpty()){
					Cell cell = stack.pop();//取出终点
					cell.c='*';//设置为可通路径
					//栈中除了含有路径之外，还包含了未继续探索的单元
					while (!stack.isEmpty()&&!isNearByCell(stack.peek(),cell)){//不连续相邻的，删除
						stack.pop();
					}
				}
				System.out.println("---------------------");
				displayMaze(cells);
				return;
			}else{//未找到终点之前
				boolean isContinue = false;
				if(!cells[x+1][y].isVisited&&cells[x+1][y].c=='0'){//右 (未被访问且不是强)
					cells[x+1][y].isVisited = true;
					stack.push(cells[x+1][y]);
					isContinue = true;
				}
				if(!cells[x][y+1].isVisited&&cells[x][y+1].c=='0'){//下 (未被访问且不是强)
					cells[x][y+1].isVisited = true;
					stack.push(cells[x][y+1]);
					isContinue = true;
				}
				if(!cells[x-1][y].isVisited&&cells[x-1][y].c=='0'){//左 (未被访问且不是强)
					cells[x-1][y].isVisited = true;
					stack.push(cells[x-1][y]);
					isContinue = true;
				}
				if(!cells[x][y-1].isVisited&&cells[x][y-1].c=='0'){//上 (未被访问且不是强)
					cells[x][y-1].isVisited = true;
					stack.push(cells[x][y-1]);
					isContinue = true;
				}
				if(!isContinue){//该节点的周围都不能继续访问了，删除之
					stack.pop();
				}
			}
		}
	}
	/**
	 * 判断是否是邻近的单元格
	 * @param cell1
	 * @param cell2
	 * @return
	 */
	private boolean isNearByCell(Cell cell1, Cell cell2) {
		// TODO Auto-generated method stub
		if(cell1.x==cell2.x&&Math.abs(cell1.y-cell2.y)==1){//上下相邻
			return true;
		}
		if(cell1.y==cell2.y&&Math.abs(cell1.x-cell2.x)==1){//左右相邻
			return true;
		}
		return false;
	}
	/**
	 * 根据迷宫矩阵，创建迷宫的Cell矩阵
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
	 * 打印迷宫
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
