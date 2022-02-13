package strings.decode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoultionUsingPattern {
	
	public static void main(String[] args) {
		
		
		
		String s="100[leetcode]";
		
		
		Pattern pattern=Pattern.compile("[%d]");
		Matcher matcher=pattern.matcher(s);
		
		
	}

}
