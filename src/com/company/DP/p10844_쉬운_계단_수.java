package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10844_쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        long[][] dp = new long[n+1][10];

        for( int i =1; i<10; i++){
            dp[1][i] = 1;
        }

        for (int i=2; i<=n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j + 1];
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
        }

        long count=0;
        for (int j =0; j<10; j++)
                count += (dp[n][j]  % 1000000000);

        System.out.println(count% 1000000000);

    }
}
