package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 빙2573 {
    public static int n,m;
    public static int[][] map;
    public static int[] dx ={0,1,0,-1};
    public static int[] dy ={-1,0,1,0};
    public static void main(String[] args) throws IOException {
        int year =0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n =Integer.parseInt(t[0]);
        m =Integer.parseInt(t[1]);
        map = new int[n][m];
        for (int i = 0; i<n; i++){
            t = bufferedReader.readLine().split(" ");
            for (int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(t[j]);
            }
        }

        while(true) {
            int count =0;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j, visited);
                        count++;
                    }
                }
            }
            if (count>1) {
                System.out.println(year);
                break;
            }

            if(count==0){
                System.out.println(0);
                break;
            }

            map = melting();
            print_array(map);
            year++;
        }

//        Runtime.getRuntime().gc();
//        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.print(usedMemory/1024/1024 + " mbytes");
    }
    public static void print_array(int[][] array){

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j]+" ");
                }
                System.out.println("");
            }
            System.out.println("");
    }
    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x =x;
            this.y=y;
        }
    }
    public static void bfs(int i, int j, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(j,i));
        visited[i][j]=true;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for(int t = 0; t<4; t++){
                int ny = y+dy[t];
                int nx = x+dx[t];
                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[ny][nx] && map[ny][nx]>0){
                    visited[ny][nx] =true;
                    queue.offer(new Point(nx,ny));
                }
                if(map[ny][nx]==0) visited[ny][nx] =true;
            }
        }

    }

    public static int[][] melting(){
        int[][] nmap = new int[n][m];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if(map[i][j]==0) continue;

                int count = 0;
                for(int t = 0; t<4; t++){
                    int y = i+dy[t];
                    int x = j+dx[t];
                    if(x>=0 && x<m && y>=0 && y<n && map[y][x]==0){
                        count++;
                    }
                }
                nmap[i][j] = map[i][j] - count;
                if(nmap[i][j]<0) nmap[i][j]=0;
            }
        }
        return nmap;
    }
}
