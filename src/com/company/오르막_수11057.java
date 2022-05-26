package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막_수11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] dp = new int[n+1][10];

        for (int i = 0; i< 10; i++)
            dp[1][i]= 1;


        if(n>1)
            for (int fn=2; fn<=n; fn++) {
                for (int i = 0; i < 10; i++) {
                    int sum = 0;
                    for (int j = 0; j <= i; j++)
                        sum += dp[fn-1][j];
                    dp[fn][i] = sum;
                    dp[fn][i] %=10007;
                }
            }

        long ans =0;
        for (int i: dp[n]) ans+=i;
        System.out.println(ans%10007);
    }
}
