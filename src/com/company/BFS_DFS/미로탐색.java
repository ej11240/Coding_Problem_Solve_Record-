package com.company.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {

    static int[][] adjust ;
    static boolean[][] visited;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        adjust =new int[N+1][M+1];

        for (int i =0; i<N; i++){
            String[] line = reader.readLine().split("");
            for (int j = 0; j<M; j++){
                int v = Integer.parseInt(line[j]);
                adjust[i][j] = v;
            }
        }

        visited = new boolean[N+1][M+1];

        bfs(0,0);

        System.out.println(adjust[N-1][M-1]);
    }

    public static void bfs (int x,int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[y][x] = true;

        while (!queue.isEmpty()){
            Point p = queue.poll();
            x = p.getX(); y = p.getY();

            for (int i = 0; i<4; i++){

                int cx = p.getX()+dx[i];
                int cy = p.getY()+dy[i];

                if( cx<0 || cy>=N || cx>=M || cy<0) continue;

                if(visited[cy][cx]==false && adjust[cy][cx] ==1){
                    adjust[cy][cx] = adjust[y][x] +1 ;
//                    System.out.println(adjust[y][x]+", y:"+y+", x:"+x+", "+cy+","+cx+", "+adjust[cy][cx]);
//                    for (int t =0; t<N; t++){
//                        for (int j = 0; j<M; j++){
//                            System.out.print(adjust[t][j]+" ");
//                        }
//                        System.out.println("");
//                    }
                    queue.add(new Point(cx,cy));
                }
            }
        }

    }

    static class Point {
        final private int x;
        final private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }
    }
}
