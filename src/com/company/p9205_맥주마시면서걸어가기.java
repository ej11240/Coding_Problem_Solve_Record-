package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p9205_맥주마시면서걸어가기 {
    static boolean found;
    static Node[] places;
    static StringBuilder sb;
    static int N;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void bfs() {
        while(!queue.isEmpty()) {
            int curPlace = queue.poll();
            if(curPlace == N+1) {
                found = true;
                break;
            }

            for(int i=N+1; i>=1; i--) {
                if(!visited[i] && possibleDist(curPlace, i)) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }

        }
    }

    public static boolean possibleDist(int curPlace, int destPlace) {
        if(Math.abs(places[curPlace].x - places[destPlace].x) + Math.abs(places[curPlace].y - places[destPlace].y) > 1000) {
            return false;
        }
        else
            return true;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder("");
        StringTokenizer st;
        for(int t = 0; t<T; t++) {
            queue = new LinkedList<>();
            found = false;
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N+2];
            places = new Node[N+2];
            for(int i=0; i<N+2; i++) {
                st = new StringTokenizer(br.readLine());
                places[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            visited[0] = true;
            queue.offer(0);
            bfs();
            if(found)
                sb.append("happy").append("\n");
            else
                sb.append("sad").append("\n");
        }
        System.out.println(sb);
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

