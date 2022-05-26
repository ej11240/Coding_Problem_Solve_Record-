package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class p2579 {
    public static void p2579v1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n= Integer.parseInt(br.readLine());

        Integer[] array = new Integer[300];
        Integer[] dp = new Integer[300];


        for( int i=0;i<n; i++){
            int t= Integer.parseInt(br.readLine());
            array[i]=t;
        }

        Arrays.fill(dp,0);
        dp[0] = array[0];
        dp[1] = max(array[0]+array[1], array[1]);
        dp[2] = max(array[0]+array[2], array[1]+array[2]);

        for( int i=3; i<n; i++ ) {
            // 점화식:
            dp[i] = max(dp[i-2] + array[i], dp[i-3] + array[i] + array[i-1]);
            //마지막 계단 전의 계단을 밟았을 경우-> 마지막 계단 전전의 계단은 밟지 못한다.
            //마지막 계단 전의 계단을 밟지 않았음 <- 마지막 계단 전전의 계단을 밟고 왔다.
        }

        System.out.println(dp[n-1]);

    }
    public static Integer max(int i, int j){
        if( i > j ) return i;
        else return j;
    }

    public static void p2579() throws IOException{

        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        int[] array = new int[301];
        int[] dp = new int[301];


        for( int i=0;i<n; i++){
            array[i]=sc.nextInt();
        }

        dp[0] = array[0];
        dp[1] = array[0]+array[1];
        dp[2] = Math.max(array[0]+array[2], array[1]+array[2]);

        for( int i=3; i<n; i++ ) {
            // 점화식:
            dp[i] = Math.max(dp[i-2] + array[i], dp[i-3] + array[i] + array[i-1]);
            //마지막 계단 전의 계단을 밟았을 경우-> 마지막 계단 전전의 계단은 밟지 못한다.
            //마지막 계단 전의 계단을 밟지 않았음 <- 마지막 계단 전전의 계단을 밟고 왔다.
        }

        System.out.println(dp[n-1]);

    }
}
