package com.vivek.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinTime {

	private int job[];
	public MinTime(int[] job){
		this.job = job;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String line1 = br.readLine(); 
		int n = 4;
		int t = 5;
		int job[] = {10,7,8,12,6,8};
		MinTime minTime = new MinTime(job);
		int min = minTime.getMinTime(n, t);
		System.out.println(min);
	}
	
	public int getMinTime(int n, int t){
		int min = 0;
		//4x = sum*5
		int c = n;
		int[] jobTime = new int[job.length+1];
		for(int i=0;i<jobTime.length;i++){
			jobTime[i] = t*job[i];
		}
		while(c>0){
			
		}
		
		return min;
	}

}
