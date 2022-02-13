package strings.decode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
//		String s="3[a2[cb]]";
//		String s="3[a2[c]]";
//		String s="1[f4[gh[2[t]]]]";
//		String s="3[a]2[bc]";
//		String s="2[abc]3[cd]ef";
//		String s="abc3[cd]xyz";
		String s="100[leetcode]";
		
//		String expected="abcabccdcdcdef";
//		String expected="abccdcdcdxyz";
//		String expected="aaabcbc";
		String expected="accaccacc";
		
		
		String result = "";
		Stack<Character> queue=new Stack<Character>();
		Map<Integer, String> strings=new HashMap<Integer,String>();
		
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==']') {
				 StringBuilder partial = new StringBuilder();
				while(!queue.isEmpty() && queue.peek()!='[') {
					char c=queue.pop();
					//System.out.print(c);
					partial.append(String.valueOf(c));
				}
				
				if(queue.peek() == '[') {
					queue.pop();
				}
				
				if(Character.isDigit(queue.peek())) {
					strings.put(Integer.parseInt(String.valueOf(queue.pop())) , partial.reverse().toString());
				}
			}else {
				queue.add(s.charAt(i));
			}
			
		}

		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))){
				stack.add(Integer.parseInt(String.valueOf(s.charAt(i))));
			}
			String complete="";
			if(s.charAt(i)==']') {
				while(!stack.isEmpty()) {
					StringBuilder partial = new StringBuilder();
					int index=stack.pop();
					for(int j=0;j<index;j++) {
						partial.append(strings.get(index)+complete);
					}
					 complete=partial.toString();
				}
			}
			
		if(!queue.isEmpty()) {
			if(s.charAt(i)==queue.firstElement()) {
				
				result=result+queue.get(0);
				queue.remove(0);
			}
			
		}
			// if ends
			result=result+complete;
		}
		
		System.out.println(result);
		
		if(expected.equals(result)) {
			System.out.println("Correct !!!");
			
			
		}else {
			System.out.println("Try Again.....");
		}
	}
}
