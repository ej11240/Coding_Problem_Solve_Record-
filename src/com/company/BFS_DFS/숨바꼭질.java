package com.company.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질 {
    public static int s,k;
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] t = b.readLine().split(" ");
        s= Integer.parseInt(t[0]);
        k= Integer.parseInt(t[1]);


    }
    public static void bfs(int t){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX];

        queue.add(s);
        visited[s]=true;
        int count =0;
        while (!queue.isEmpty()&& s!=k){
            int a = queue.poll();

            if(visited[a]==false) {
                
                count++;
            }
        }
    }
}
