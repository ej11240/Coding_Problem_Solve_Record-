package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        for (int i=0; i<tcase; i++ ){
            String[] t = br.readLine().split(" ");
            int n = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            int count =0;
            Queue<int[]> queue = new LinkedList<>();
            t = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                queue.add(new int[] { j, Integer.parseInt(t[j]) });
            }

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean able = true;
                for(int[] tt : queue)
                    if(tt[1] > poll[1])
                        able = false;
                if (able) {
                    count++;
                    if (poll[0]==m)
                        break;
                }
                else queue.add(poll);
            }
            System.out.println(count);
        }
    }
}
