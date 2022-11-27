package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int k = Integer.parseInt(t[1]);

        t = bufferedReader.readLine().split("");
        LinkedList<Integer> list = new LinkedList<>();

        int count =0;
        for (int i =0; i<n; i++){
            int c = t[i].charAt(0) -'0';
            while (count<k && !list.isEmpty() && list.peek()<c){
                    list.poll();
                    count++;
            }
            System.out.println(list.size());
            list.add(c);

        }

        StringBuffer sb = new StringBuffer();
        for (int i =0; i<n-k; i++){
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
