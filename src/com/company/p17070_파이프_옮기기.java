package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17070_파이프_옮기기 {
    public static int n;
    public static int[][] map;
    public static int[] dx = {0,1,1};
    public static int[] dy = {1,0,1};
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n+1][n+1];
        for (int i = 1; i<=n; i++) {
            String[] t = bufferedReader.readLine().split(" ");
            for (int j = 1; j<=n; j++){
                map[i][j] = Integer.parseInt(t[j-1]);
            }
        }
        dfs(1,2,0);
        System.out.println(answer);

    }
    public static void dfs(int x, int y, int d){
        if(x==n && y==n){
            answer++;
            return;
        }
        for(int i = 0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if((d==0 && i==1) || (d==1 && i==0)) continue;
            if((x < 1 || y < 1 || y > n || x > n || map[x][y]==1 )==false) continue;
            if(i==2 && (map[x+1][y]==1 || map[x][y+1]==1)) continue;
            dfs(nx, ny, i);

        }
    }
}
