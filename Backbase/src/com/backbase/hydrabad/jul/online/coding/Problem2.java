package com.backbase.hydrabad.jul.online.coding;

public class Problem2 {

		public static final String SYSTEM_SEPERATOR="/";
		
	    public static String changeDirectoryString(String currentDirectory, String command) {
	        
	        if(null==command || !command.startsWith("cd ") || null== currentDirectory)
	        	throw new IllegalStateException();
	        
	        
	        String operation=command.split("cd ")[1];
	        String[] currentDirectoryPath=currentDirectory.split("/");
	        if(operation.contains(" "))
	        	throw new IllegalStateException();
	        
	        if(operation.equals("/"))
	        	return "/";
	        
	        if(operation.equals("..")) {
	        	StringBuilder sb=new StringBuilder();
	        	for(int i=1;i<currentDirectoryPath.length-1;i++) {
	        		sb.append(SYSTEM_SEPERATOR);
	        		sb.append(currentDirectoryPath[i]);
	        	}
	        	return sb.toString();
	        }
	        
	        if(operation.contains("..")) {
	        	String[] subOperation=operation.split("/");
	        	
	        	for(int i=0; i< subOperation.length;i++) {
	        		currentDirectory=changeDirectoryString(currentDirectory, "cd "+subOperation[i]);
	        	}
	        	return currentDirectory;
	        }else {
	        	if(operation.startsWith("/")) {
	        		return operation;
	        	}else {
	        	
	        		String outputDir= currentDirectory+SYSTEM_SEPERATOR+operation;
	        		if(outputDir.endsWith("/")) 
	        			outputDir=outputDir.substring(0, outputDir.length()-1);
	        		return outputDir;
	        	}
	        }
	       
	    }
	
	public static void main(String[] args) {
		
		String str=changeDirectoryString("/test/task/java","cd /test/task");
		System.out.println("Result=="+str);
	}
}
