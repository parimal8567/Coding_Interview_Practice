package com.facebook.puzzles;

public class WrongAnswers {
	
	public String getWrongAnswers(int N, String C) {
		StringBuilder sb=new StringBuilder();
	    for(int i=0;i<N;i++){
	      char answer=C.charAt(i);
	        if(answer=='A')
	          sb.append("B");
	        else
	          sb.append("A");
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		WrongAnswers wa=new WrongAnswers();
		int N=3;
		String C="BAB";
		int N1=5;
		String C1="BBBBB";
		String result=wa.getWrongAnswers(N1, C1);
		System.out.println("Result="+result);
		
	}

}
