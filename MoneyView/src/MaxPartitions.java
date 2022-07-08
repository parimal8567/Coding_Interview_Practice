
public class MaxPartitions {
	
	public static int maxPartition(int[] arr) {
		int max=0;int ans=0;
		for(int i=0;i<arr.length;++i) {
			max=Math.max(arr[i], max);
			
			if(max==i)
				ans++;
		}
		return ans;
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 1, 0, 2, 3, 4 };
        int n = arr.length;
        int maxPartitions=maxPartition(arr);
        System.out.println("Result="+maxPartitions);
        
	}

}
