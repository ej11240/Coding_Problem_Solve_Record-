package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 수리공항승1449 {
    public static void main(String[] args) throws IOException {
        int n , tapelength;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        tapelength = Integer.parseInt(t[1]);
//        int[] points = new int[n];
        LinkedList<Integer> points = new LinkedList<>();
        t = br.readLine().split(" ");
        for(int i =0; i<n; i++){
            points.add(Integer.parseInt(t[i]));
        }
        Collections.sort(points);
        int count =0;
        double left =1000; double right = 0;

        for (int i:points) {
            double tl = i-0.5;
            double tr = i+0.5;
            if(right<tr){
                count++;
                left = tl;
                right = tl+tapelength;
//                if(tl+tapelength>=1000){
//                    right=1000;
//                    left = 1000-tapelength;
//                }
            }
        }
        System.out.println(count);
    }
}
