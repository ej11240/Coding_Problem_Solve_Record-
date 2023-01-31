package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1495_기타리스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int s = Integer.parseInt(t[1]);
        int m = Integer.parseInt(t[2]);
        boolean[][] dp = new boolean[n+1][m+1];
        int[] array = new int[n+1];
        t = br.readLine().split(" ");
        for (int i=1; i<n+1; i++){
            array[i] = Integer.parseInt(t[i-1]);
        }
        dp[0][s] = true; //n번째 곡일때 S가능 여부

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (!dp[i - 1][j]) {
                    continue;
                }
                if (j - array[i] >= 0) {
                    dp[i][j - array[i]] = true;
                }
                if (j + array[i] <= m) {
                    dp[i][j + array[i]] = true;
                }
            }
        }

        boolean flag = false;
        for (int i=m; i>0; i--){
            if(dp[n][i]){ System.out.println(i);break; }
            if (i==1) System.out.println(-1);
        }

    }
}
