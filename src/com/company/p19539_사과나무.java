package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p19539_사과나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] t = bufferedReader.readLine().split(" ");

        int sum = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int tt = Integer.parseInt(t[i]);
            sum += tt;
            if( tt % 2 == 1 ) {
                num++;
            }
        }
        if( sum % 3 == 0 && num <= sum / 3) {
            System.out.println("YES");
        }else
            System.out.println("NO");
    }
}