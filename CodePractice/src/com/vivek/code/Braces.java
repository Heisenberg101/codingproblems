package com.vivek.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Braces {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine(); 
		int n = Integer.parseInt(line1);
		String[] s = new String[n];
		for(int i=0;i<n;i++){
			s[i] = br.readLine();
		}

		String[] op = braces(s);
		for(int i=0;i<op.length;i++){
			System.out.println(op[i]);
		}
		
	}
	
 static String[] braces(String[] values) {
		String[] arr = new String[values.length];
		
		for(int i=0;i<values.length;i++){
			Stack<Character> str = new Stack<Character>();
			char[] chr = values[i].toCharArray();
			for(int j=0;j<chr.length;j++){
				if(str.isEmpty())
					str.push(chr[j]);
				else{
					char tmp = (char) str.pop();
					if(chr[j]==tmp)
						continue;
				}
			}
			if(str.isEmpty()){
				arr[i] = "YES";
			}
			else{
				arr[i] = "NO";
			}
		}
		
		return arr;
    }
 
 static int getMinimumUniqueSum(int[] arr) {
	 int sum = 0;
	 int max =0;
	 for(int i=0;i<arr.length;i++){
		 if(arr[i]>max)
			 max = arr[i];
	 }
	 
	 int[] cnt = new int[max+1];
	 for(int i=0;i<=max;i++)
		 cnt[i] = 0;
	 for(int i=0;i<arr.length;i++){
		 cnt[arr[i]]++;
	 }
	 
	 for(int i=0;i<arr.length;i++){
		 sum = sum+arr[i];
		 if(cnt[arr[i]]>1){
			for(int j=0;j<cnt[arr[i]]-1;j++){
				
			}
		 }
	 }
	 
	 return sum;

 }
 
 

}
