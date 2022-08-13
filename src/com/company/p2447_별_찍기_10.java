package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2447_별_찍기_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                recur(i,j, n);
            }
            System.out.println();
        }
    }
    public static void recur(int i, int j, int n){
        if((i/n)%3 == 1 &&(j/n)%3 == 1){
            System.out.print(" ");
        }
        else {
            if(n/3==0) System.out.print("*");
            else recur(i,j,n/3);
        }
    }
}
