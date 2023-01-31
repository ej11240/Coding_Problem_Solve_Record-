package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] t = bufferedReader.readLine().split(" ");
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int[] index = new int[n+1];
        Stack<Integer> stack = new Stack<>();
        int answer = dp[1];
        for (int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(t[i-1]);
            dp[i] = 1;
        }

        for (int i=2; i<=n; i++){
            for (int j=i-1; j>=1; j--){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    index[i] = j;
                }
            }
        }

        int idx = 1;
        for (int i=1; i<=n; i++){
            if(answer < dp[i]){
                answer = dp[i];
                idx = i;
            }
        }

        System.out.println(answer);

        while (idx>0){
            stack.push(arr[idx]);
            idx = index[idx];
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }

    }
}
