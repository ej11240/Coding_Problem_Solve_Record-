package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질3 {
    public static int n, k, answer;
    public static int[] time;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);
        time = new int[100001];
        visited = new boolean[100001];
        answer=Integer.MAX_VALUE;

        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()){
            int point = queue.poll();
            if(point==k) answer = Math.min(answer, time[k]);

            if( point*2<=100000 && !visited[point*2] ) {
                queue.offer(point*2);
                visited[point*2]=true;
                time[point*2] = time[point];
            }
            if(point-1>=0 && !visited[point-1] ) {
                queue.offer(point-1);
                visited[point-1]=true;
                time[point-1] = time[point]+1;
            }
            if( point+1<=100000 && !visited[point+1]) {
                queue.offer(point+1);
                visited[point+1]=true;
                time[point+1] = time[point]+1;
            }
        }
    }
}