package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11722_가장_긴_감소하는_부분수열 {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] t = bufferedReader.readLine().split(" ");
        int[] list = new int[n];
        for (int i = 0; i<n; i++){
            list[i] = Integer.parseInt(t[i]);
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j <= i; j++){
                if(list[i]<list[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] +1;
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < n; i++){
            answer = answer < dp[i] ? dp[i] : answer;
        }
        System.out.println(answer);
    }
}
