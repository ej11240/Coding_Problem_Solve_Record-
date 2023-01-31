package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1450_냅색문제 {
    public static int n;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        c = Integer.parseInt(t[1]);
        int[] weight = new int[n+1];
        t = bufferedReader.readLine().split(" ");
        for (int i=0; i<n; i++){
            weight[i] = Integer.parseInt(t[i]);
        }



    }
}
