package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class p13904_과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Homework[] homeworks = new Homework[n];

        int min = -1;
        for (int i =0; i<n; i++){
            String[] t = bufferedReader.readLine().split(" ");
            homeworks[i] = new Homework(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
            min = min < homeworks[i].day ? homeworks[i].day : min;
        }
        System.out.println(min);

        Arrays.sort(homeworks, (o1, o2) -> o2.day - o1.day);
//        for (int i =0; i<n; i++){
//            System.out.println(homeworks[i].day);
//        }

        int result = 0;
        int works_idx = 0;
        PriorityQueue<Homework> q = new PriorityQueue<>();
        for(int i = min; i > 0; i--) {
            while(works_idx < n && homeworks[works_idx].day >= i) {
                q.offer(homeworks[works_idx++]);
            }
            if(!q.isEmpty()) result += q.poll().score;
        }
        System.out.println(result);
    }
    public static class Homework implements Comparable<Homework> {
        int day;
        int score;
        public Homework(int day, int score){
            this.day = day;
            this.score = score;
        }
//
        @Override
        public int compareTo(Homework homework) {
            return homework.score - this.score;
        }

    }


}
