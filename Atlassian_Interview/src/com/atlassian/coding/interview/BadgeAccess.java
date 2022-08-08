package com.atlassian.coding.interview;

/**
We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
  ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
  ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
  ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
  ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
  ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
  ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
  ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
  ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
  ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
  ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
  ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"],
];

Expected output (in any order)
   Paul: 1315 1355 1405
   Jose: 830 835 855 915 930
   Zhang: 10 109 110
   Amos: 500 503 504

n: length of the badge records array
*/

import java.util.*;

public class BadgeAccess {
  public static void main(String[] argv) {
    
    String[][] badgeTimes = new String[][] {
      {"Paul", "1355"},
      {"Jennifer", "1910"},
      {"Jose", "835"},
      {"Jose", "830"},
      {"Paul", "1315"},
      {"Chloe", "0"},
      {"Chloe", "1910"},
      {"Jose", "1615"},
      {"Jose", "1640"},
      {"Paul", "1405"},
      {"Jose", "855"},
      {"Jose", "930"},
      {"Jose", "915"},
      {"Jose", "730"},
      {"Jose", "940"},
      {"Jennifer", "1335"},
      {"Jennifer", "730"},
      {"Jose", "1630"},
      {"Jennifer", "5"},
      {"Chloe", "1909"},
      {"Zhang", "1"},
      {"Zhang", "10"},
      {"Zhang", "109"},
      {"Zhang", "110"},
      {"Amos", "1"},
      {"Amos", "2"},
      {"Amos", "400"},
      {"Amos", "500"},
      {"Amos", "503"},
      {"Amos", "504"},
      {"Amos", "601"},
      {"Amos", "602"},
      {"Paul", "1416"},
    };
    
    
    Map<String, TreeSet<String>> output=getBadges(badgeTimes);
    
    for(String key:output.keySet()) {
    	
    	TreeSet<String> result=output.get(key);
    	System.out.print(key+": "+result.toString());
    	System.out.println();
    }
    
    
  }
  
  public static Map<String, TreeSet<String>> getBadges(String[][] badgeTimes){
    Map<String, List<String>> badgeTimesMap=new HashMap<>();
    
    for(int i=0;i<badgeTimes.length;i++){
      String empName=badgeTimes[i][0];
      String empTime=badgeTimes[i][1];
      
      if(null==badgeTimesMap.get(empName)){
        List<String> timings=new ArrayList<>();
        timings.add(empTime);
        badgeTimesMap.put(empName, timings);
      }else{
        List<String> timings=badgeTimesMap.get(empName);
        timings.add(empTime);
      }
      
    }
    
    Map<String, TreeSet<String>> ouput=new HashMap<>();
    for(String name:badgeTimesMap.keySet()){
      List<String> timings=badgeTimesMap.get(name);
      if(timings.size()>3){
    	TreeSet<Integer> sortedTimings=new TreeSet<>();
        for(String time:timings)
        	sortedTimings.add(Integer.parseInt(time));
        
        TreeSet<String> timing=checkValidEntries(sortedTimings);
        if(timing.size()>=3)
        	ouput.put(name,timing);
      }
      
    }
    return ouput;
    
  }
  
  public static int getTime(String time) {
	  if(time.length()>2) {
		  int hour=Integer.parseInt(time)/100;
		  int minute=Integer.parseInt(time)%100;
		  return hour*60 + minute;
	  }else return Integer.parseInt(time);
  }
  
  public static int getTime(Integer time) {
	  if(String.valueOf(time).length() >2) {
		  int hour=time/100;
		  int minute=time%100;
		  return hour*60 + minute;
	  }else return time;
  }
  
  public static TreeSet<String> checkValidEntries(TreeSet<Integer> sortedTimings){
    
	  TreeSet<String> subSet=new TreeSet();
	  for(Integer timings:sortedTimings) {
		  int startMinutes=getTime(timings);
		  for(Integer innerTimings:sortedTimings) {
			  if(getTime(innerTimings)-startMinutes <= 60 && innerTimings >= timings ) {
				  subSet.add(String.valueOf(innerTimings));
			  }
		  }
		  if(subSet.size()>=3) 
				break;
		  else
			  subSet.clear();
	  }
	  
	  return subSet;

    
  }
  
}
