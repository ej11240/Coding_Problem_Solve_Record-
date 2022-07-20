package com.company;

import java.io.*;

public class 평범한_배낭_12865 {
    public static void main(String[] args)throws IOException {
        int n,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[][] dp = new int[101][100001];
        for( int i = 1; i<=n; i++){
            t = br.readLine().split(" ");
            w[i] = Integer.parseInt(t[0]);
            v[i] = Integer.parseInt(t[1]);
        }
        for(int i = 1; i<=n; i++){
            for( int j = 1; j<=k; j++){
                if(j-w[i]>=0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}