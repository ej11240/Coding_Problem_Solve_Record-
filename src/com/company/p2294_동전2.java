package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2294_동전2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t= br.readLine().split(" ");
        int n=Integer.parseInt(t[0]);
        int k=Integer.parseInt(t[1]);
        int[] arr=new int[n+1];

        for(int i=1;i<=n;i++)
            arr[i]=Integer.parseInt(br.readLine());

        int[] dp = new int[k+1];
        Arrays.fill(dp, 100001);
//        for (int i=0; i<k+1; i++)
//            dp[i] = 999999;
        dp[0] =0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if(dp[k]==100001)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
