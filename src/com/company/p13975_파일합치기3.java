package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class p13975_파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int i=0; i<t; i++){
            int n = Integer.parseInt(bf.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            String[] tt = bf.readLine().split(" ");
            for (int j=0; j<n; j++)
                queue.offer(Long.parseLong(tt[j]));

            long answer =0;
            while (queue.size()>1){
                long a = queue.poll();
                long b = queue.poll();
                queue.offer(a+b);
                answer += a+b;
            }
            System.out.println(answer);
        }
    }
}
