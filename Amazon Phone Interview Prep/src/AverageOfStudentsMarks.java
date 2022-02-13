
public class AverageOfStudentsMarks {

	public int[][] highFive(int[][] items) {
		
		
		return items;
	       
    }
	
	
	public static void main(String[] args) {
		AverageOfStudentsMarks avg=new AverageOfStudentsMarks();
		int[][] items=new int[6][3];
		
		
		for(int i=0;i<items.length;i++) {
			for(int j=0;j<items.length;j++) {
				items[i][j]=0;
			}
		}
		
		avg.highFive(items);
	}
}
