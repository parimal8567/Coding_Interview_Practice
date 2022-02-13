package String;

public class DuplicateRemove {

	public String removeDuplicate(String str) {
		char[] strArr=str.toCharArray();
		
		char[] result=new char[strArr.length];
		int k=0;
		for(int i=0;i<=strArr.length-1;i++) {
			char c=strArr[i];
			boolean flag=true;
			for(int j=0;j<=strArr.length-1;j++) {
				flag=true;
				if(c==strArr[j]&&i!=j)
				{
					flag=false;
					break;
				}
				
			}
			if(flag) {
				result[k]=c;
				k++;
			}
		}
		return String.valueOf(result);
	}
	
	public static void main(String[] args) {
		DuplicateRemove dr=new DuplicateRemove();
		String str=dr.removeDuplicate("Parimal");
		System.out.println(str);
	}
}
