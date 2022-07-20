package com.company.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1로_만들기_1463 {
    public static Integer[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        visited = new Integer[num+1];
//        System.out.println(visited[num]);
        visited[0] = visited[1] = 0;
        dp(num);
        System.out.println(visited[num]);
    }
    public static int dp(int n){

        if(n==1) return 0;
        if(n==0) return 0;

        if(visited[n]==null) {
            if (n % 6 == 0) {
                visited[n]= Math.min(dp(n / 3), Math.min(dp(n / 2 ), dp(n - 1))) +1;
            } else if (n % 3==0) {
                visited[n] =  Math.min(dp(n / 3),dp(n-1))+1;
            } else if(n % 2 == 0){
                visited[n] = Math.min(dp(n / 2 ), dp(n - 1)) +1;
            } else {
                visited[n] = dp(n - 1) +1;
            }
        }

        return visited[n];
    }
}
