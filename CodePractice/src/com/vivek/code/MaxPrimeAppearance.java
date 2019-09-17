package com.vivek.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MaxPrimeAppearance {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine(); 
		int[] arr = new int[Integer.parseInt(line1)];
		for(int i=0;i<Integer.parseInt(line1);i++){
			String line2 = br.readLine();
			arr[i] = Integer.parseInt(line2);
		}
		String line3 = br.readLine();
		int k = Integer.parseInt(line3);
		System.out.println(getOutcomeOfTheFeat(arr,k));

	}
	
	public static int getLargestNumberWithPrimeOccurences(int[] inputArray, int minOccurence) {
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
		Arrays.sort(inputArray);
		int l = inputArray.length;
		int[] countArr = new int[inputArray[l-1]+1];
		for(int i=l-1;i>=0;i--){
			if(!hm.containsKey(inputArray[i])){
				hm.put(inputArray[i], 1);
				countArr[inputArray[i]] = 1;
			}
			else{
				hm.put(inputArray[i], hm.get(inputArray[i])+1);
				countArr[inputArray[i]] = hm.get(inputArray[i]);
			}
		}
		
		Iterator<Integer> itr = hm.keySet().iterator();
		while(itr.hasNext()){
			int el = itr.next();
			int cnt = countArr[el];
			if(!(cnt>=minOccurence)){
				continue;
			}
			int currCnt = 0;
			for(int i=1;i<cnt;i++){
				if(cnt%i==0)
					currCnt++;
			}
			if(currCnt==1){
				return el;
			}
		}
		return -1;

    }
	
	public static String getOutcomeOfTheFeat(int[] weights, int marginOfError) {
		int totSum = 0;
		for(int i=0;i<weights.length;i++){
			totSum+=weights[i];
		}
		int sumHalf = totSum/2;
		Arrays.sort(weights);
		int l = weights.length;
		int currSum = 0;
		int remSum = 0;
		int oddSum = 0;
		int evenSum = 0;
		for(int i=l-1;i>=0;i--){
			currSum+=weights[i];
			if(currSum>=sumHalf){
				remSum = totSum - currSum + i;
				if(remSum==currSum)
					return "Perfectly Balanced";
				else if(Math.abs(remSum-currSum)<=marginOfError)
					return "Balanced within "+Math.abs(remSum-currSum);
			}
		}
		
		for(int i=l-1;i>=0;i--){
			evenSum+=weights[i];
			if(i>0)
				oddSum+=weights[--i] +1;
		}
		if(evenSum==oddSum)
			return "Perfectly Balanced";
		else if(Math.abs(evenSum-oddSum)<=marginOfError)
			return "Balanced within "+Math.abs(evenSum-oddSum);
		
		return "Not Balanced";
    }

}
