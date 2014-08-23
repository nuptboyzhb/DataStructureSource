/*
 * 编程之美
 */
package edu.njupt.zhb;

import java.util.Stack;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-26  Nanjing,njupt,China
 */
public class TestBCZM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TestBCZM().reverseWords("  "));
	}
	/**
	 * 单词顺序反转
	 * @param s 输入字符串
	 * @return 处理结果
	 */
//	public String reverseWords(String s) {
//		char []str=s.toCharArray();
//        for(int i=0;i<str.length/2;i++){
//            char temp=str[i];
//            str[i]=str[str.length-1-i];
//            str[str.length-1-i]=temp;
//        }
//        int prev=0;
//        for(int i=0;i<str.length;i++){
//            if(str[i]==' '){
//                for(int j=prev;j<(i+prev)/2;j++){
//                    char temp=str[j];
//                    str[j]=str[i+prev-1-j];
//                    str[i+prev-1-j]=temp;
//                }
//                prev=i+1;
//            }
//        }
//        for(int j=prev;j<(str.length+prev)/2;j++){
//            char temp=str[j];
//            str[j]=str[str.length+prev-1-j];
//            str[str.length+prev-1-j]=temp;
//        }
//        return new String(str);
//    }
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		Stack<String> stack=new Stack<String>();
		String result="";
		int prev=0;
		while(prev<s.length()&&s.charAt(prev)==' '){
			prev++;
		}
		for(int i=prev;i<s.length();i++){
			if(s.charAt(i)==' '){
				String temp=s.substring(prev,i);
				prev=i+1;
				stack.push(temp);
			}
		}
		while(!stack.isEmpty()){
			result=result+stack.pop()+" ";
		}
		if(result.length()>0){
			result = result.substring(0,result.length()-1);
		}
		return result;
	}
}
