package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15486_퇴사2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] work = new int[1500001][2];
        for (int i=1; i<=n; i++){
            String[] t = br.readLine().split(" ");
            work[i][0] = Integer.parseInt(t[0]);
            work[i][1] = Integer.parseInt(t[1]);
        }

        int answer= 0;
        int[] dp = new int[1500001];
        //모든 일에 대해서
        for (int i=1; i<=n+1; i++) {
            answer = Math.max(answer, dp[i]);
            //일 끝나는 날이 퇴사일 전인지
            if(i+work[i][0] > n+1)  continue;
            dp[i+work[i][0]] = Math.max(answer+work[i][1], dp[i+work[i][0]]);
        }
        System.out.println(answer);
    }
}
