package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p12852_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bufferedReader.readLine());
//        System.out.println(n);

        int[] dp = new int[1000002];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i=4; i<=n; i++) dp[i] = Integer.MAX_VALUE;

        for (int i =4; i<=n; i++){
            if(i%3==0)
                dp[i] = Math.min(dp[i/3]+1,dp[i]);
            if(i%2==0) {
                dp[i] = Math.min(dp[i/2]+1,dp[i]);
            }
            dp[i] = Math.min(dp[i-1]+1, dp[i]);
//            System.out.println(dp[i]);
        }
//        System.out.println("//");

        System.out.println(dp[n]);
        while (true){
            System.out.print(n+" ");
            if(n==1) break;
            if(n%3==0 && (dp[n/3]+1)==dp[n]) n/=3;
            else if(n%2==0 && (dp[n/2]+1)==dp[n]) n/=2;
            else n--;
        }
    }
}
