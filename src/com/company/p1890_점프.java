package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1890_점프 {
    static int n ;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n][n];
        for (int i =0; i<n; i++) {
            String[] t = bufferedReader.readLine().split(" ");
            for (int j =0; j<n; j++){
                arr[i][j] = Integer.parseInt(t[j]);
            }
        }

        dp = new int[n][n];
        dp[0][0] = 1;
        for (int i =0; i<n; i++){
            for (int j=0; j<n; j++){
                if(dp[i][j]==0 ||(i==n-1 && j==n-1)) continue;
                int v = arr[i][j];
                int d = v+i;
                int r = v+j;
                if(d<n) dp[d][j] = dp[d][j] + dp[i][j];
                if(r<n) dp[i][r] = dp[i][r] + dp[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}

