package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p2352_반도체_설계 {
    public static int n;
    public static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        list = new int[n];
        int answer =1;
        for(int i = 0; i<n; i++){
            int p = Integer.parseInt(bufferedReader.readLine());
            if(list[answer-1]<p){
                list[answer++] = p;
            }
            else {
                list[binery(0,answer-1,p)] =p;
            }
        }
        System.out.println(answer);

    }
    public static int binery(int low, int high, int p){

        int mid;

        while(high >= low){
            mid = (high + low)/2;
            if(list[mid] < p)
                low = mid + 1;
            else
                high = mid;
        }
        return high;

    }
}
