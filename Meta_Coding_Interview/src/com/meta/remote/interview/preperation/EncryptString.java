package com.meta.remote.interview.preperation;

public class EncryptString {
	
	
	public static void main(String[] args) {
	
//		String s="abcdefghijklmNOPQRSTUVWXYZ0123456789";
		String input="All-convoYs-9-be:Alert1.";
		String s="abcdZXYzxy-999.@";
		int rotationFactor=200;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<input.length();i++) {
			int c=input.charAt(i);
			char newToken=input.charAt(i);
			if(newToken=='Y') {
				System.out.println("Test");
			}
			int encryptedAsciiVal = 0;
			if(64<c && c<91) {
				if(c+rotationFactor>90)
					encryptedAsciiVal=(c+rotationFactor)-26;
				else
					encryptedAsciiVal=c+rotationFactor;
				
				
			}else if(96<c && c<123) {
					if(c+rotationFactor>122)
					encryptedAsciiVal=(c+rotationFactor)-26;
				else
					encryptedAsciiVal=c+rotationFactor;
			} else if(47<c && c<58) {
				if(c+rotationFactor>57)
					encryptedAsciiVal=(c+rotationFactor)-10;
				else
					encryptedAsciiVal=c+rotationFactor;
			}
			if(0!=encryptedAsciiVal)
				newToken=(char)encryptedAsciiVal;
				
			sb.append(newToken);
			
		}
		
		System.out.println(sb.toString());
	}

	private static int encryptChar(int c, int rotationFactor,int i,int start) {
		return ((c+rotationFactor)/i)+start;
	}

}
