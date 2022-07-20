package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11727_2xn_타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[n+1];
        dp[0]=0;
        if(n==1) {
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(3);
            return;
        }
        dp[1]=1; dp[2]=3;
        for(int i =3; i<=n; i++){
            dp[i] = ( dp[i-2]*2 + dp[i-1] ) % 10007;
        }
        System.out.println(dp[n]);
    }
}
