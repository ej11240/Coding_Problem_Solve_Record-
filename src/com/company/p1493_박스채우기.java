package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1493_박스채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int L,W,H;
        String[] t = bufferedReader.readLine().split(" ");
        L = Integer.parseInt(t[0]);
        W = Integer.parseInt(t[1]);
        H = Integer.parseInt(t[2]);
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Long> list = new ArrayList<>();
        for (int i =0; i<n; i++){
             t = bufferedReader.readLine().split(" ");
             list.add(Long.parseLong(t[1]));
        }
        long len = (long) Math.pow(2L,n-1);
        System.out.println(len);
        long sum = 0;
        long before = 0;
        for (int i = n - 1; i >= 0; i--) {
            before *= 8;

            long value = (long) ((L / len) * (W / len) * (H / len) - before);
            value = Math.min(list.get(i), value);

            sum += value;
            before += value;

            len = (long) Math.sqrt(len);
            System.out.println(len);
        }

        if (before == L * W * H) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }

}
