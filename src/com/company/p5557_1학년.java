package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        String[] t = br.readLine().split(" ");
        for (int i=0; i<n; i++){
            list[i] = Integer.parseInt(t[i]);
        }

        long[][] dp = new long[n][21];
        dp[0][list[0]] = 1;
        for (int i=1; i<n-1; i++){

            for (int j=0; j<21; j++){
                if(dp[i-1][j]!=0){
                    int pre = j;
                    int next = list[i];
                    if(pre+next>=0 && pre+next<=20){
                        dp[i][pre+next] += dp[i-1][pre];
                    }
                    if(pre-next>=0 && pre-next<=20){
                        dp[i][pre-next] += dp[i-1][pre];
                    }
                }
            }
        }

        System.out.println(dp[n-2][list[n-1]]);
    }

}
