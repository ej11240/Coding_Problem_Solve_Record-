package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11660_구간합구하기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int[][] dp = new int[1025][1025];

        for (int i = 0; i < n; i++) {
            t = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(t[j]);
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + num;
            }
        }

        for (int i = 0; i < m; i++) {
            t = bufferedReader.readLine().split(" ");
            int x1 = Integer.parseInt(t[0]);
            int y1 = Integer.parseInt(t[1]);
            int x2 = Integer.parseInt(t[2]);
            int y2 = Integer.parseInt(t[3]);

            int ans = dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1];
            System.out.println(ans);
        }

    }
}
