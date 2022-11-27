package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1461_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        // 양의 큐, 음의 큐를 각각 따로 만든다, 내림차수 정렬
        PriorityQueue<Integer> plusqueue = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> minusqueue = new PriorityQueue<>((p1, p2) -> p2 - p1);

        t = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(t[i]);
            if (tmp >= 0)
                plusqueue.offer(tmp);
            else
                minusqueue.offer(Math.abs(tmp));
        }

        int max = 0;
        // 비어있지 않은 큐의 제일 멀리 있는 책 위치 저장
        if (plusqueue.isEmpty()) {
            max = minusqueue.peek();
        }
        else if (minusqueue.isEmpty()) {
            max = plusqueue.peek();
        }
        else {
            max = Math.max(plusqueue.peek(), minusqueue.peek());
        }

        int answer =0;
        while (!plusqueue.isEmpty()){
            int tmp =plusqueue.poll();
            //한번에 m권씩 빼니까
            for (int i=0; i<m-1; i++){
                plusqueue.poll();
                if(plusqueue.isEmpty()) break;
            }
            answer += tmp*2;
        }

        while (!minusqueue.isEmpty()){
            int tmp = minusqueue.poll();
            for (int i=0; i<m-1; i++){
                minusqueue.poll();
                if(minusqueue.isEmpty()) break;
            }
            answer += tmp*2;
        }

        answer -= max;

        System.out.println(answer);
    }
}