package com.facebook.telephonic.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * 
 * Given an array , partition it by K as window size
 * and return the average of each rolling window.
 * Input- [1,2,3,4,5]
 * Output-[2.0,3.0,4.0]
 *
 */

public class ArraySlicing {
	
	public double[] getAverageOfSlices(int k,int[] input) {
		
		List<Integer> data=Arrays.stream(input).boxed().collect(Collectors.toList());
		List<Double> output=new ArrayList<>();
		
		Map<Integer,List<Integer>> slices=new HashMap<>();
		int sliceCounter=0;
		for(int i=0;i<=input.length-k;i++,sliceCounter++) {
			List<Integer> slice=data.subList(i, i+k);
			slices.put(sliceCounter, slice);
		}
		
		for(Integer counter:slices.keySet()) {
			List<Integer> slice=slices.get(counter);
			OptionalDouble avg=slice.stream().mapToInt(number->number.intValue()).average();
			output.add(avg.getAsDouble());
			
		}
		
		
		return output.stream().mapToDouble(Double::doubleValue).toArray();
	}
	
	public static void main(String[] args) {
		ArraySlicing as=new ArraySlicing();
		
		int[] input= {1,2,3,4,5};
		int k=3;
		
		double[] output=as.getAverageOfSlices(k,input);
		System.out.print("Answer=[");
		for(int i=0;i<output.length;i++)
			System.out.print(output[i]+",");
		
		System.out.println("]");
	}

}
