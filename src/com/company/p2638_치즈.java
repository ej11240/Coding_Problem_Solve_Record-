package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2638_치즈 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;
    static int[][] cheeze;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        cheeze = new int[n][m];
        int count =0;
        for(int i =0; i<n; i++){
            t = bufferedReader.readLine().split(" ");
            for (int j=0; j<m; j++){
                cheeze[i][j]
                        = Integer.parseInt(t[j]);
                if(cheeze[i][j]==1) count++;
            }
        }
        int answer=0;
        Queue<Point> list = new LinkedList<>();

        dfs(0,0);
        while (true){
            for(int i=0;i<n;i++) {
                for (int j = 0; j < m; j++) {
                    if (cheeze[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int X = i + dx[k];
                            int Y = j + dy[k];

                            if (cheeze[X][Y] == -1) cnt++;
                        }

                        if (cnt >= 2) list.add(new Point(i, j));
                    }
                }
            }

            if(list.size()==0) break;

            while (!list.isEmpty()){
//                Point point
                int x = list.peek().x;
                int y = list.peek().y;

                list.poll();

                cheeze[x][y] = -1;

                for(int i=0;i<4;i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(cheeze[nx][ny]==0) dfs(nx, ny);
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
    public static void dfs(int x, int y){
        if(cheeze[x][y]==0) cheeze[x][y] = -1;
        else return;

        for (int i =0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx>=0 && nx<n && ny>=0 &&ny<m){
                dfs(nx,ny);
            }
        }

        return;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
