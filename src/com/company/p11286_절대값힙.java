package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p11286_절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue= new PriorityQueue<>((o1, o2) -> {
            int minus = Math.abs(o1)-Math.abs(o2);
            return minus == 0 ? ( 1 > o2 ? 1 : -1 ) : minus;
        });

        for (int i =0; i<n; i++){
            int t = Integer.parseInt(bufferedReader.readLine());

            if(t!=0) {
                queue.add(t);
            }

            else {
                if(queue.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
