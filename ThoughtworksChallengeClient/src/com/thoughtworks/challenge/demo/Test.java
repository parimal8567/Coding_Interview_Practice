package com.thoughtworks.challenge.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	
	public static void main(String[] args) {
		String str="Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a blender. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that still must be done. There is a coolness, a calmness, when the sun does set.";
		String str1="A tag question is a device used to turn a statement into a question. There are a few exceptions to this, frequently expressing an element of surprise or sarcasm: So you have made your first million, have you? Oh, that's your plan, is it? Be careful not to put a question mark at the end of an indirect question. Be careful to distinguish between an indirect question, and a question that is embedded within a statement which we do want to end with a question mark.";
		Long startTime=System.currentTimeMillis();
//		Pattern p = Pattern.compile("[a-zA-Z]+"); 
		Pattern p1= Pattern.compile("[aeiuoAEIOU]");
        
        Matcher m1 = p1.matcher(str1); 
		

        int aCount=0;
        int eCount=0;
        int iCount=0;
        int oCount=0;
        int uCount=0;
        while (m1.find()) {
        	String c=m1.group();
        	System.out.println(c);
           if(c.equalsIgnoreCase("a")) {
        	   aCount++;   
           }
           if(c.equalsIgnoreCase("e")) {
        	   eCount++;
           }
           if(c.equalsIgnoreCase("o")) {
        	   oCount++; 
           }
           if(c.equalsIgnoreCase("i")) {
        	   iCount++;
           }
           if(c.equalsIgnoreCase("u")) {
        	   uCount++;
           }
        } 
        
        Map<String,Integer> vowelCount=new LinkedHashMap<String,Integer>();
        vowelCount.put("a", aCount);
        vowelCount.put("e", eCount);
        vowelCount.put("i", iCount);
        vowelCount.put("o", oCount);
        vowelCount.put("u", uCount);
        System.out.println(vowelCount.toString());
        Long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);
//		System.out.println(str.length());
		
		
		
	}
}
