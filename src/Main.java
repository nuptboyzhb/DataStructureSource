import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String string=in.next();
        	int []num=new int[10];
        	int []chars=new int[26];
        	boolean flag=false;
        	for(int i=0;i<string.length();i++){
        		char ch=string.charAt(i);
        		if(!isValid(ch)){
        			flag=true;
        			System.out.println("<invalid input string>");
        			break;
        		}
        		if(ch>='0'&&ch<='9'){
        			num[ch-'0']++;
        		}else if(ch>='a'&&ch<='z'){
        			chars[ch-'a']++;
        		}
        	}
        	if(flag==false){
        		boolean isLeft=true;
        		while(isLeft){
        			isLeft=false;
        			for(int i=0;i<num.length;i++){
        				if(num[i]>0){
        					num[i]--;
        					isLeft=true;
        					System.out.print((char)(i+'0'));
        				}
        			}
        			for(int i=0;i<chars.length;i++){
        				if(chars[i]>0){
        					chars[i]--;
        					isLeft=true;
        					System.out.print((char)(i+'a'));
        				}
        			}
        		}
        	}
        }
	}
	public static boolean isValid(char ch){
		if((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')){
			return true;
		}else {
			return false;
		}
	}

}
