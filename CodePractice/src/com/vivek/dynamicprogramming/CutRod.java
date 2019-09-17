package com.vivek.dynamicprogramming;

import javax.crypto.CipherInputStream;

public class CutRod {

	public int getMax(int a, int b){
		return a>b?a:b;
	}
	
	public int getMaxSum(int[] price, int n){
		int[] val = new int[n+1];
		val[0] = 0;
		for(int i=1;i<n+1;i++){
			int max_val = Integer.MIN_VALUE;
			
			for(int j=0;j<i;j++){
				max_val = getMax(max_val,price[j]+val[i-j-1]);
			}
			val[i] = max_val;
		}
		
		
		return val[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CutRod obj = new CutRod();
		int[] price = {4,5,10};
		System.out.println(obj.getMaxSum(price, 2));
		
	}

}
