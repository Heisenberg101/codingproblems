package com.vivek.dynamicprogramming;

import java.util.HashMap;
import java.util.Iterator;

public class CoinChange {

	public static int getCoinChange(int[] coin, int n){
		int[] change = new int[n+1];
		for(int i=0;i<n+1;i++)
			change[i] = 0;
		change[0]=1;
		
		for(int i=0;i<coin.length;i++){
			
			for(int j=coin[i];j<=n;j++){
					change[j] = change[j] + change[j-coin[i]];
				
			}
		}
		
		
		return change[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int coins[] = {3,5,10};
		int count = getCoinChange(coins, 20);*/
		String text = "nlaebolkoloonbalxballpoon";
		CoinChange coinChange = new CoinChange();
		//int count = coinChange.maxNumberOfBalloons(text);
		int[] arr = {1,-2, 1};
		int k = 5;
		int sum = coinChange.kConcatenationMaxSum(arr, k);
		
		System.out.println(sum);

	}
	
	public HashMap<Character, Integer> pushBalloonText(){
        HashMap<Character, Integer> balloonMap = new HashMap<Character, Integer>();
        String balloonText = "balloon";
        for(int i=0; i<balloonText.length();i++)
            if(!balloonMap.containsKey(balloonText.charAt(i)))
                balloonMap.put(balloonText.charAt(i),0);
        
        return balloonMap;
    }
    public int maxNumberOfBalloons(String text) {
        
    	HashMap<Character, Integer> balloonMap = pushBalloonText();
        int count = 0;
        if(text.length()<7)
            return count;
        for(int i=0;i<text.length();i++){
            Character ch = text.charAt(i);
            if(balloonMap.containsKey(ch)){
            	balloonMap.put(ch, balloonMap.get(ch) +1);
            }
        }
        Iterator itr = (Iterator) balloonMap.keySet().iterator();
        count = balloonMap.get((Character) itr.next());
        while(itr.hasNext()){
        	Character ch = (Character) itr.next();
        	if(ch.equals('o') || ch.equals('l')){
        		if(balloonMap.get(ch)/2 < count )
        			count = balloonMap.get(ch)/2;
        	}
        	else{
        		if(balloonMap.get(ch) < count )
        			count = balloonMap.get(ch);
        	}
        		
        		
        }
        
       return count; 
        
    }
    
    
    public int kConcatenationMaxSum(int[] arr, int k) {
    	
    	
    	/*int maxSum = 0;
    	int currSum = 0;
    	double modval = (Math.pow(10,9) + 7);
    	for(int j=0;j<k; j++){
    		for(int i=0;i<arr.length;i++){
        		
        		if(arr[i]>0 && currSum<0)
            		currSum = arr[i];
        		else if(arr[i]%modval +currSum%modval > currSum%modval){
            			currSum = (int) (arr[i]%modval + currSum%modval);
        		}
            	else if(arr[i]<0 && currSum>=0)
            		currSum = (int) (currSum%modval + arr[i]%modval);
            	
        		if(currSum%modval>maxSum%modval)
        			maxSum = (int) (currSum%modval);
        	}
        	
    	}*/
    	
    	int maxSum = 0;
        int currSum = 0;
        int modval = 1000000007;
        
        for(int i=0;i<arr.length;i++){
        
             maxSum = maxSum+arr[i];

        } 
         int maxPreSum = 0;
         int currPreSum = 0;
         for(int i=arr.length-1;i>=0;i--){
             if(arr[i]>0 && currPreSum<0)
                 currPreSum = arr[i];
             else if(arr[i] +currPreSum > currPreSum){
                     currPreSum = arr[i] + currPreSum;
             }
             else if(arr[i]<0 && currPreSum>=0)
                 currPreSum = currPreSum + arr[i];

            if(currPreSum>maxPreSum)
             maxPreSum = currPreSum;
             
         }
         
         int maxPostSum = 0;
         int currPostSum = 0;
         for(int i=0;i<arr.length;i++){
             if(arr[i]>0 && currPostSum<0)
                 currPostSum = arr[i];
             else if(arr[i] +currPostSum > currPostSum){
                     currPostSum = arr[i] + currPostSum;
             }
             else if(arr[i]<0 && currPostSum>=0)
                 currPostSum = currPostSum + arr[i];

            if(currPostSum>maxPostSum)
             maxPostSum = currPostSum;
             
         }

         int finMaxSum = 0;
         if(maxSum*k<(maxSum*(k-2)+maxPreSum+maxPostSum))
             finMaxSum = (maxSum*(k-2)+maxPreSum+maxPostSum);
         if(maxSum*(k-1)+maxPreSum>finMaxSum)
             finMaxSum = maxSum*(k-1)+maxPreSum;
         if(maxSum*(k-1)+maxPostSum>finMaxSum)
             finMaxSum = maxSum*(k-1)+maxPostSum;
     	    
     	return finMaxSum%modval;
    	
    	//return maxSum;
        
    }

}
