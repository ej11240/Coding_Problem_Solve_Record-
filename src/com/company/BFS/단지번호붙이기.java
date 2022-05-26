package com.company.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기 {
    public static int n;
    public static LinkedList<Point> all_homes;
    public static int current=1;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static int[][] map;
    public static LinkedList<Integer> count;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(b.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        count = new LinkedList<>();
        //입력 시 집이 있는 위치를 큐에 넣음
        all_homes = new LinkedList<>();
        for (int i =0; i<n; i++){
            String[] t = b.readLine().split("");
            for(int j =0; j<n; j++) {
                map[j][i] = Integer.parseInt(t[j]);
            }
        }

        for (int i =0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[j][i] && map[j][i]==1){
                    Point p = new Point(i,j);
                    int c =bfs(p);
                    count.add(c);
                    current++;
                }
            }
        }

        for (int i =0; i<n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(map[j][i]+" ");
            System.out.println("");
        }

        System.out.println(count.size());
        Collections.sort(count);
        for (int i :count)
            System.out.println(i);

    }

    static class Point {
        int y, x;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static int bfs(Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        int c =1;

        while(!queue.isEmpty()){
            Point p= queue.poll();
            visited[p.y][p.x]=true;
            for(int i = 0; i<4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if(x>=0 && y>=0 && x<n && y<n && map[y][x]==1 && !visited[y][x]){
                    queue.add(new Point(x,y));
                    c++;
                    map[y][x] = c;
                }
            }
        }
        return c;

    }
}
