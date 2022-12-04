package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] t = bufferedReader.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i=0; i<=n; i++){
             arr[i] = Integer.parseInt(t[i]);
        }
    }
}
