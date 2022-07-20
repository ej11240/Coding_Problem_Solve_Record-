package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11726_2xn타일링 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        dp = new int[n+1];
        if(n==1){
            System.out.println(1);
            return;
        }
        if(n==2) {
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i<=n; i++){
            dp[i] = ( dp[i-2]+dp[i-1] )%10007;
        }

        System.out.println(dp[n]);
    }
}
