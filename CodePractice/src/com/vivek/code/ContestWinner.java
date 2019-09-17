package com.vivek.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ContestWinner {

	private int[] prodArr = new int[1000];
	
	private class Node{
		
		int value;
		int index;
		
		public Node(int v, int i){
			this.value = v;
			this.index = i;
		}
	}
	
	private class MaxComparator implements Comparator<Node>{


		@Override
		public int compare(Node o1, Node o2) {
			 	Integer x1 = o1.value;
	            Integer x2 = o2.value;
	            int sComp = x1.compareTo(x2);

	            if (sComp != 0) {
	               return sComp;
	            } else {
	               x1 = o1.index;
	               x2 = o2.index;
	               return x1.compareTo(x2);
	            }
		}
		
	}
	
	private class MinComparator implements Comparator<Node>{


		@Override
		public int compare(Node o1, Node o2) {
			 	Integer x1 = o1.value;
	            Integer x2 = o2.value;
	            int sComp = x2.compareTo(x1);

	            if (sComp != 0) {
	               return sComp;
	            } else {
	               x1 = o1.index;
	               x2 = o2.index;
	               return x2.compareTo(x1);
	            }
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine(); 
		int t = Integer.parseInt(line1);
		ContestWinner cw = new ContestWinner();
		for(int i=0;i<cw.prodArr.length;i++){
			cw.prodArr[i] = 1;
		}
		int[] luckyDraw = new int[t];
		for(int i=0;i<t;i++){
			luckyDraw[i]=Integer.parseInt(br.readLine());
		}
		String[] op = cw.getWinnerRunner(luckyDraw).split(":");
		System.out.println(op[0]);
		System.out.println(op[1]);

	}
	
	public int getFactorial(int n,int arr_size){
		
		int sum=0;
		int carry = 0;
		int r = 0;
		int i=0;
		for(i=0;i<arr_size;i++){
			sum = n*prodArr[i] + carry;
			r = sum%10;
			prodArr[i] = r;
			carry = sum/10;
		}
		
		while(carry>0){
			r=carry%10;
			prodArr[i] = r;
			carry=carry/10;
			arr_size++;
			i++;
		}
		
		return arr_size;
	}
	
	public int getNProductDiff(int n){
		int x = 0;
		int arr_size = 1;
		int y = 0;
		Arrays.fill(prodArr, 1);
		
		for(int i=2;i<=n;i++){
			arr_size = getFactorial(i,arr_size);
		}
		
		for(int i=0;i<arr_size;i++){
			x = x + prodArr[i];
			if(prodArr[i]==0)
				y++;
		}
		
		return x-y;
	}
	
	public String getWinnerRunner(int[] luckyDraw){
		
		LinkedList<Node> nList = new LinkedList<>();
		for(int i=0;i<luckyDraw.length;i++){
			
			int xy = getNProductDiff(luckyDraw[i]);
			Node node = new Node(xy, i);
			nList.add(node);
		}
		
		//Collections.sort(nList, new MaxComparator());
		
		Node max = Collections.max(nList, new MaxComparator());
		Node min = Collections.max(nList, new MinComparator());
		
		return (max.index+1)+" "+max.value+":"+(min.index+1)+" "+min.value;
	}

}
