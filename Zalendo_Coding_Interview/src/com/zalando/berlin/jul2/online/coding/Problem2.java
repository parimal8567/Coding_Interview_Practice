package com.zalando.berlin.jul2.online.coding;

public class Problem2 {
	

		
	public boolean solution(String S, String T) {
        int sLength=findLength(S);
        int tLength=findLength(T);
        
        if(sLength!=tLength)
        	return false;
       
        String sOCR=fillString(S,sLength);
        String tOCR=fillString(T,tLength);
        
        for(int i=0;i<sOCR.length();i++) {
        	if(sOCR.charAt(i)!=tOCR.charAt(i)) {
        		if(sOCR.charAt(i)!='x' && tOCR.charAt(i)!='x')
        			return false;
        	}
        		
        }
        return true;
    }
	
	
	private String fillString(String data, int length) {
		char[] charArr=new char[length];
		int i=0;
		for(char c:data.toCharArray()) {
        	if(Character.isDigit(c)) {
        		  int val=Integer.parseInt(String.valueOf(c));
        		  for(int j=0;j<val;j++) {
        			  charArr[i]='x';
        			  i++;
        		  }
        	}else {
        		charArr[i]=c;
        		i++;
        	}
        		
		}
        
        return String.valueOf(charArr);
	}


	private int findLength(String s) {
		if(null==s || s.isEmpty())
			return 0;
		int length=0;
		for(char c:s.toCharArray()) {
			if(Character.isDigit(c))
				length=length+Integer.parseInt(String.valueOf(c)) ;
			else
				length++;
			
		}
		return length;
	}


	public static void main(String[] args) {
		Problem2 p1=new Problem2();
		String a="A2Le";
		String b="2pL1";
		
		String p="3x2x";
		String q="8";
		
		String m="a10";
		String n="10a";
		
		String c="ba1";
		String d="1Ad";
		System.out.println(p1.solution(a,b));
	}

}
