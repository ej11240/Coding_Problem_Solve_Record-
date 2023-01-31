package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p17142 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int n;
    public static int m;
    public static int[][] arr;
    public static List<Point> virus;
    public static Point[] active;
    public static int count0;
    public static int mintime;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        arr = new int[n][n];
        count0 =0;
        virus = new ArrayList<>();
        active = new Point[m];
        mintime = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            t = bufferedReader.readLine().split(" ");
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(t[j]);
                if(arr[i][j]==0) count0++;
                if (arr[i][j]==2) virus.add(new Point(i,j,0));
            }
        }

        //기존 연구소 문제와 다르게 배열값을 입력받을 때 0의 개수를 카운트한 후,
        // 확산 시에도 0의 개수를 카운트의 둘의 값을 비교하여 같으면 확산이 완료된 것이고 아니면 확산이 실패한 것으로 로직을 구성

        if(count0 ==0) System.out.println(0);
        else {
            selectVirus(0,0);
            System.out.println(mintime == Integer.MAX_VALUE ? -1 : mintime);
        }

    }
    public static void selectVirus(int start, int scount){
        if(scount==m){
            bfs(count0);
            return;
        }

        for (int i=start; i<virus.size(); i++){
            active[scount] = virus.get(i);
            selectVirus(i+1, scount+1); // 재귀 호출을 이용한 백트레킹으로 M개의 바이러스를 선택함
        }
    }

    public static void bfs(int emptySpaceCount){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i=0; i<m; i++){
            Point point= active[i];
            visited[point.x][point.y] = true;
            queue.add(point);
        }

        while (!queue.isEmpty()){
            Point p = queue.poll();
            for (int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || arr[nx][ny] == 1) continue;

                if(arr[nx][ny]==0){
                    count0--;
                }

                if(count0==0){
                    mintime = Math.min(mintime, p.time+1);
                    return;
                }

                visited[nx][ny] = true;
                queue.add(new Point(nx,ny,p.time+1));
            }
        }
    }
    public static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }
}
