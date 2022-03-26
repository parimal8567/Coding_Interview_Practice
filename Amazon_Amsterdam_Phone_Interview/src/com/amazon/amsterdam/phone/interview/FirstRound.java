package com.amazon.amsterdam.phone.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Date : 21 March 2022
 * N= {1,2,5,2,8,9,4,1,5,7,0,4};
 * K= 3
 *
 *t1={1,2,5}= 5
 *t2={2,5,2}= 5
 *t3={5,2,8}= 8
 *t4={2,8,9}= 9
 *t5={8,9,4}= 9
 *t6={9,4,1}= 9
 *t7={4,1,5}= 5
 *t8={1,5,7}= 7
 *t9={5,7,0}= 7
 *t10={7,0,4}=7
 *
 *Return HV List
 *HV List={5,5,8,9,9,9,5,7,7,7}
 */

public class FirstRound {

	public List<Integer> solution(List<Integer> orders, int k) {
		List<Integer> hvList=new ArrayList<>();
		for(int i=0;i<=orders.size()-k;i++) {
			List<Integer> subOrderList=orders.subList(i, i+k);
			TreeSet<Integer> set=new TreeSet<>();
			for(int j=0;j<k;j++) {
				set.add(subOrderList.get(j));
			}
			hvList.add(set.last());
		}
		
		return hvList;
	}
	
	public static void main(String[] args) {
		FirstRound fr=new FirstRound();
		List<Integer> orders=new ArrayList<>(Arrays.asList(1,2,5,2,8,9,4,1,5,7,0,4));
		int k=3;
		List<Integer> hvList=fr.solution(orders,k);
		System.out.println(hvList.toString());
		
	}
}
