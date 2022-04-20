package com.facebook.telephonic.interview;

public class ArraySlicingNotOptimised {

	public double[] getAverageOfSlices(int k,int[] input) {
		double[] output=new double[input.length-k+1];
		for(int i=0;i<=input.length-k;i++) {
			double result=0;
			for(int j=i;j<i+k;j++) {
				result=result+input[j];
			}
			result=result/k;
			output[i]=result;
		}
		return output;
	}
	public static void main(String[] args) {
		ArraySlicingNotOptimised as=new ArraySlicingNotOptimised();
		
		int[] input= {1,2,3,4,5};
		int k=3;
		
		double[] output=as.getAverageOfSlices(k,input);
		System.out.print("Answer=[");
		for(int i=0;i<output.length;i++)
			System.out.print(output[i]+",");
		
		System.out.println("]");
	}
}
