package com.facebook.puzzles.level1;

import java.util.*;

public class Cafeteria {

	public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
		Map<Long,List<Long>> data=new HashMap<>();
		
		for(int i=0;i<M;i++) {
			long diner=S[i];
			List<Long> diners=fillData(data,diner,K,N);
			List<Long> existingDiners=data.get(1);
			if(null==existingDiners)
				data.put(1L, diners);
			else
				existingDiners.addAll(diners);
				
		}
		
//		List<Long> diners=data.get(1);
//		for(long i=1;i<=N;i++) {
//			if(!diners.contains(i)) {
//				List<Long> available=data.get(0);
//				if(null==available)
//					available= new ArrayList<>();
//				available.add(i);
//			}
//				
//		}
		
		
		
		return 0L;
		
	}
	
	
	List<Long> fillData(Map<Long,List<Long>> data, long diner, long K, long N){
		List<Long> diners=data.get(1);
			
		if(null==diners)
			diners=new ArrayList<>();
		
		diners.add(diner);
		
		if(diner-K>0) {
			for(long i=diner;i>diner-K;i--) {
				if(!diners.contains(i-1))
					diners.add(i-1);
			}
		}
		if(diner+K<N) {
			for(long i= diner;i<diner+K;i++) {
				if(!diners.contains(i+1))
					diners.add(i+1);
			}
		}
		
		return diners;
	}

	public static void main(String[] args) {

//		long N = 10;
//		long K = 1;
//		int M = 2;
//		long[] S = {2L, 6L};
		
		long N = 15;
		long K = 2;
		int M = 3;
		long[] S = {11L, 6L, 14L};
		
		Cafeteria cafe=new Cafeteria();
		long count=cafe.getMaxAdditionalDinersCount(N, K, M, S);
		
		System.out.println("Answer="+count);
		
	}
}
