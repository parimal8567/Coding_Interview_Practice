package com.atlassian.coding.interview;

import java.util.*;

/*
You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
pairs1 = [
	["Foundations of Computer Science", "Operating Systems"],
	["Data Structures", "Algorithms"],
	["Computer Networks", "Computer Architecture"],
	["Algorithms", "Foundations of Computer Science"],
	["Computer Architecture", "Data Structures"],
	["Software Design", "Computer Networks"]
]



In this case, the order of the courses in the program is:
	Software Design
	Computer Networks
	Computer Architecture
	Data Structures
	Algorithms
	Foundations of Computer Science
	Operating Systems

Sample output 1:
	"Data Structures"

Sample input 2:
pairs2 = [
    ["Algorithms", "Foundations of Computer Science"],
    ["Data Structures", "Algorithms"],
    ["Foundations of Computer Science", "Logic"],
    ["Logic", "Compilers"],
    ["Compilers", "Distributed Systems"],
]

Sample output 2:
	"Foundations of Computer Science"

Sample input 3:
pairs3 = [
	["Data Structures", "Algorithms"],
]

Sample output 3:
	"Data Structures"

All Test Cases:
halfway_course(pairs1) => "Data Structures"
halfway_course(pairs2) => "Foundations of Computer Science"
halfway_course(pairs3) => "Data Structures"

Complexity analysis variables:

n: number of pairs in the input
**/

public class CourseOrder {
	
	  public static void main(String[] argv) {
	    
	    String[][] pairs1 = {
	        {"Foundations of Computer Science", "Operating Systems"},
	        {"Data Structures", "Algorithms"},
	        {"Computer Networks", "Computer Architecture"}, 
	        {"Algorithms", "Foundations of Computer Science"},
	        {"Computer Architecture", "Data Structures"},
	        {"Software Design", "Computer Networks"}
	    };

	    String[][] pairs2 = {
	        {"Algorithms", "Foundations of Computer Science"},
	        {"Data Structures", "Algorithms"},
	        {"Foundations of Computer Science", "Logic"},
	        {"Logic", "Compilers"},
	        {"Compilers", "Distributed Systems"},
	    };


	    String[][] pairs3 = {
	        {"Data Structures", "Algorithms"}
	    };
	    
	    System.out.println("******** Test Case 1 ********");
	    String result1=getMiddleCourse(pairs1);
	    System.out.println("Result ->"+result1);
	    System.out.println();
	    System.out.println("******** Test Case 2 ********");
	    String result2=getMiddleCourse(pairs2);
	    System.out.println("Result ->"+result2);
	    System.out.println();
	    System.out.println("******** Test Case 3 ********");
	    String result3=getMiddleCourse(pairs3);
	    System.out.println("Result ->"+result3);
	  }
	  
	  
	  
	  public static String getMiddleCourse(String[][] pairs){
	    Map<String, String> courseMap=new HashMap<>();
	    Map<String, String> courseMap1=new HashMap<>();
	    
	    for(int i=0;i<pairs.length;i++){
	      courseMap.put(pairs[i][1],pairs[i][0]);
	    }
	    
	    for(int i=0;i<pairs.length;i++){
	      courseMap1.put(pairs[i][0],pairs[i][1]);
	    }
	    
	    String startCourse="";
	    for(String course:courseMap.keySet()){
	        String value = courseMap.get(course);
	        if(!courseMap.containsKey(value))
	          startCourse=value;
	    }
	    
	    
	    List<String> orderedList=new ArrayList<>();
	    orderedList.add(startCourse);
	    
	    String course=startCourse;
	    System.out.println("Course Ordered List :-- ");
	    int i=1;
	    System.out.println("Course "+i+" : "+course);
	    while(null!=courseMap1.get(course)){
	    	i++;
	      String value=courseMap1.get(course);
	      orderedList.add(value);
	      System.out.println("Course "+i+" : "+value);
	      course=value;
	      
	    }
	    int middle=(orderedList.size()-1) /2;
	    
	    System.out.println("Total Size :-- "+orderedList.size());
	    return orderedList.get(middle);
	    
	  }
}
