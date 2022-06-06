package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실_배정_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in));
        System.out.println();
        int N = Integer.parseInt(bufferedReader.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            String[] t = bufferedReader.readLine().split(" ");

            int start = Integer.parseInt(t[0]);
            int end = Integer.parseInt(t[1]);
            lectures[i] = new Lecture(start, end);
        }
        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].start) {
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }
        System.out.println(pq.size());
    }
    public static class Lecture{
        int start, end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
