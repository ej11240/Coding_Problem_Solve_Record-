package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] maxdp = new int[3];
        int[] mindp = new int[3];

        int[] lastMin = new int[3];
        int[] lastMax = new int[3];
        int[] arr = new int[3];
        for (int i = 1; i <= n; ++i) {
            String[]t = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 3; ++j) {
                arr[j] = Integer.parseInt(t[j]);

                lastMin[j] = mindp[j];
                lastMax[j] = maxdp[j];
            }
            mindp[0] = arr[0] + Math.min(lastMin[0], lastMin[1]); //0 1중 작은거
            mindp[1] = arr[1] + Math.min(lastMin[0], Math.min(lastMin[1], lastMin[2])); //0 1 2 중 가장 작은거
            mindp[2] = arr[2] + Math.min(lastMin[1], lastMin[2]); // 1 2 중 작은거

            maxdp[0] = arr[0] + Math.max(lastMax[0], lastMax[1]);
            maxdp[1] = arr[1] + Math.max(lastMax[0], Math.max(lastMax[1], lastMax[2]));
            maxdp[2] = arr[2] + Math.max(lastMax[1], lastMax[2]);
        }
        int a1 = Math.max(maxdp[0], Math.max(maxdp[1], maxdp[2]));
        int a2 = Math.min(mindp[0], Math.min(mindp[1], mindp[2]));
        System.out.println(a1+" "+a2);
    }
}
