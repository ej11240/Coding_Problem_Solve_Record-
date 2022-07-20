package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9095_1_2_3_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine());
        for (int j =0; j<cases; j++){

            int n = Integer.parseInt(bufferedReader.readLine());

            int[] dp = new int[n+1];
            if(n==1) {
                System.out.println(1);
                continue;
            }
            else if(n==2) {
                System.out.println(2);
                continue;
            }
            else if(n==3) {
                System.out.println(4);
                continue;
            }
            else {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
                System.out.println(dp[n]);
            }
        }
    }
}
