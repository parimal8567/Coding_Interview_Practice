package com.facebook.telephonic.interview;

import java.util.Stack;

/**
 * 
 * Input will be a string containing numbers and operators ( *,+ only)
 * Return the result as output
 * example
 * Input - "2*3+4"
 * Output= 10 
 *
 */
public class Calculator {
	
	public int calculate(String s) {
		Stack<Integer> stack=new Stack();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='*'||c=='+') {
				int d=stack.pop();
				int num=Integer.parseInt(String.valueOf(d));
				if(c=='*') {
					int res=num*Integer.parseInt(String.valueOf(s.charAt(i+1)));
					stack.add(res);
				}else {
					int res=num+Integer.parseInt(String.valueOf(s.charAt(i+1)));
					stack.add(res );
				}
				i++;
			}else {
				stack.add(Integer.parseInt(String.valueOf(c)));
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
	
		String S="2*3+4";
		Calculator c=new Calculator();
		int result=c.calculate(S);
		System.out.println("Result="+result);
	}

}
