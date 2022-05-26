package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 포도주시식 {
    public static void main(String[] args ) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[]  array =  new int[n+1];
        for (int  i =1; i<n+1; i++)
            array[i] = Integer.parseInt(reader.readLine());

        int[] dp = new int[n+1];
        dp[1] = array[1];
        dp[2] = array[1]+array[2];
        for( int i =3; i<n+1; i++){
            dp[i] = Math.max(dp[i-3]+array[i]+array[i-1], dp[i-2]+array[i]);
            dp[i] = Math.max(dp[i-1],dp[i]);
        }
        System.out.println(dp[n]);
    }

}
