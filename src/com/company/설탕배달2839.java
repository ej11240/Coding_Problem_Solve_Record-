package com.company;

import java.io.*;

public class 설탕배달2839 {
    public static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[n+1];
        dp[3] = 1;
        if(n>=4)dp[4] = 0;
        if(n>=5)dp[5] = 1;

        for( int i =6; i<n+1; i++){
            if(dp[i-3]>0) dp[i] = dp[i-3]+1;
            if(dp[i-5]>0){
                if(dp[i]!=0) dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1) ;
                else  dp[i] = dp[i-5]+1;
            }
        }
        System.out.println(dp[n]==0?-1:dp[n]);
    }
}
