import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.stream.util.StreamReaderDelegate;

public class CasaOneChallenge {

	public static void main(String[] args) {
		
		 
		 
		String str="{}}";
		boolean isBalanced=checkBalanced(str);
		if(!isBalanced) {
			String s=makeBalanced(str,0);
		}
		
	}

	private static String makeBalanced(String str, int count) {
		char[] stringArray=str.toCharArray();
		System.out.println(str.length());
		for(int i=0;i<str.length();i++) {
			System.out.println(i%3);
			//Character c=str.charAt(i);
			Character c=stringArray[i];
			if(i%3==0) {
				//Character c=str.charAt(i);
				if(!c.equals('{')) {
					int indexOfOpening=str.indexOf('{', i);
					if(indexOfOpening != -1) {
					char tempToken=stringArray[indexOfOpening];
					stringArray[indexOfOpening]=stringArray[i];
					stringArray[i]=tempToken;
					}
					
				}
			}else {
				
				//to do check closing only
				if(!c.equals('}')) {
					int indexOfOpening=str.indexOf('}', i);
					if(indexOfOpening != -1) {
					char tempToken=stringArray[indexOfOpening];
					stringArray[indexOfOpening]=stringArray[i];
					stringArray[i]=tempToken;
					}
				}
				
			}
			
			
		}
		String str1=new String(stringArray);
		System.out.println(str1);
		
		return null;
	}
	
	private static String makeBalanced1(String str, int count) {
		char[] stringArray=str.toCharArray();
		System.out.println(str.length());
		for(int i=0;i<str.length();i++) {
			System.out.println(i%3);
			//Character c=str.charAt(i);
			Character c=stringArray[i];
			
			
			
		}
		String str1=new String(stringArray);
		System.out.println(str1);
		
		return null;
	}

	private static boolean checkBalanced(String str) {
		Queue<Character> brackets=new LinkedList<Character>();
		
		
		/*for(int i=0;i<str.length()/3;i++) {
			Character c=brackets.poll();
			if(c.equals('{')) {
				Character next=brackets.poll();
				if(next.equals('}')) {
					Character nextToNext=brackets.poll();
					if(nextToNext.equals('}')) {
						isBalanced=true;
						
					}else {
						isBalanced=false;
						break;
					}
				}else {
					isBalanced=false;
					break;
				}
			}else {
				isBalanced=false;
				break;
			}
		}
		*/
		Queue<Character> bracketsModified=null;
		
		char[] strArr=str.toCharArray();
		char[] dupStrArr=null;
		
		int count=0;
		boolean isIterationRequire=true;
		
		
		
		while(isIterationRequire) {
			int i=0;
			 isIterationRequire=false; 
			 dupStrArr=new char[strArr.length+1];
			for(Character c:strArr) {
				
				if(i%3==0) {
					// opening
					if(c.equals('{')) {
						dupStrArr[i]=c;
						//isIterationRequire=false;
						
					}else {
						dupStrArr[i]='{';
						//dupStrArr[i]=c;
						System.out.println("Count ncremented");
						
						isIterationRequire=true;
						break;
					}
					
				}else {
					//closing
					if(c.equals('}')) {
						dupStrArr[i]=c;
						//isIterationRequire=false;
					}else {
						dupStrArr[i]='}';
						//dupStrArr[i+1]=c;
						System.out.println("Count ncremented");
						
						isIterationRequire=true;
						break;
					}
				}
				i++;
			}
			if(isIterationRequire) {
				for(int j=0,k=0;j<dupStrArr.length;j++,k++) {
					if(dupStrArr[j]==0) {
						dupStrArr[j]=strArr[j-1];
					}
						
				}
				count++;
				strArr=dupStrArr;
				if(strArr.length%3!=0) {
					isIterationRequire=true;
				}
			}
			
			
		
		}
		
		System.out.println("count"+count);
		return true;
			
		
	}
}
