package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class p18310_안테나 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        int max = -1;
        String[] t = bufferedReader.readLine().split(" ");
        for (int i =0; i<n; i++){
            list.add(Integer.parseInt(t[i]));
        }
        Collections.sort(list);

        System.out.println(list.get((n-1)/2));
    }
}
