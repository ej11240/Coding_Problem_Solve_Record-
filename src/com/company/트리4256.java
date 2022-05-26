package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리4256 {
    public static int[] pre;
    public static int[] in;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        while (count>0){
            int n = Integer.parseInt(bufferedReader.readLine());
            pre = new int[1001];
            in = new int[1001];
            String[] t = bufferedReader.readLine().split(" ");
            for(int i = 0; i<n; i++)
                pre[i] = Integer.parseInt(t[i]);
            t = bufferedReader.readLine().split(" ");
            for(int i = 0; i<n; i++)
                in[i] = Integer.parseInt(t[i]);

            solution(0,0,n);
            System.out.println("");
            count--;
        }

    }
    public static void solution(int c, int left, int right){
//        if(left>right) return;
//        if(left==right){
//            System.out.print(pre[c]+" ");
//            return;
//        }
//
//        int t = in[pre[c]];
//        solution(c+1, left, t-1);
//        solution(c+t-left+1, t+1, right);
//        System.out.println(in[c]+" ");

        for(int i = left; i < right; i++){
            if(in[i]==pre[c]){
                solution(c+1, left, i);
                solution(c+i+1-left, i+1, right);
                System.out.println(pre[c]+" ");
            }
        }
    }
}
