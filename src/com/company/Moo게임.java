package com.company;

import java.util.Scanner;

public class Moo게임 {
    public static String ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        moo(n);

        System.out.println(ans);
    }

    public static void moo(int num) {
        int side = 3;
        int center = 0;

        while(num > side) {
            side = center + 4 + side * 2;
            center++;
        }

        int fb = (side - center - 3) / 2;

        if(side - fb+1 <= num) {
            moo(num - side+fb);
        }else if(num == fb+1) {
            ans = "m";
        }else {
            ans = "o";
        }
    }
}
