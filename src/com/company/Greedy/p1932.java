package com.company.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class p1932 {
    public static void main(String[] args ) throws NumberFormatException, IOException {

        //부모 노드중에서 가장 큰걸 집어넣어야하는데 여기서 [i-1][0]과 [i-1][1] 중 가장 큰 값을 넣으면 그걸 더해넣기만 하면 된다. 당연히 [i-1][0]의 값은 0이니까 가장큰값은 [i-1][1]이다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] tree = new int[501][501];
        int[][] dp = new int[501][501];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {

            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = tree[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int max = dp[n][1];
        for (int i = 2; i <= n; i++) {
            if (max < dp[n][i])
                max = dp[n][i];
        }

        System.out.println(max + "");

    }
}
