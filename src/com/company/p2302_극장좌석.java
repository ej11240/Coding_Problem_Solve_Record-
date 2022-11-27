package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2302_극장좌석 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        int split = Integer.parseInt(br.readLine());
        long answer=1;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=40; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int start=0;
        for(int i=1;i<=split; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer = answer*dp[vip-start-1];
            start=vip;
        }
        answer = answer*dp[n-start];

        System.out.println(answer);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int split = Integer.parseInt(br.readLine());
//        int[] divided_list = new int[split+1];
//        int last_num =0;
//        int max =-1;
//        for (int i =0; i<split; i++) {
//            int t =Integer.parseInt(br.readLine());
//            divided_list[i] = t-last_num-1;
////            System.out.println(t+" "+divided_list[i]);
//            last_num = t;
//            max = max<divided_list[i] ? divided_list[i] :max;
//        }
//        divided_list[split] = n-last_num;
//        if(split==0) {divided_list[0]=n;max = n;}
////        System.out.println("max: "+max);
//        int[] dp = new int[n+1];
//        dp[0] =1;
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i=3; i<max+1; i++){
//            dp[i]=dp[i-1]+dp[i-2];
////            System.out.println(dp[i]);
//        }
//        int answer =1;
////        System.out.println("---");
//        for (int i=0; i<split+1; i++){
////            System.out.println(dp[divided_list[i]]+" "+divided_list[i]);
//            answer *=dp[divided_list[i]];
//        }
//        System.out.println(answer);
//    }

}
