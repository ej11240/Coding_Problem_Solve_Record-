package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class p2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int k = Integer.parseInt(t[1]);
        int[] list = new int[n+1];
        for (int i = 1; i<=n; i++){
            int tt = Integer.parseInt(bufferedReader.readLine());
            list[i] = tt;
        }

        Arrays.sort(list);
        int[] dp = new int[10001];
        dp[0] = 1;
        for( int i = 1; i <= n; i++ ){
            for(int j = list[i]; j<=k; j++){
                dp[j] = dp[j] + dp[j-list[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
