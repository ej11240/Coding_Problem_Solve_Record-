package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1937_욕심쟁이_판다 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static int answer ;
    static int ansmove;
    public static int[] dx ={0,1,0,-1};
    public static int[] dy ={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        int minx = 0, miny=0, min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            String [] t = bufferedReader.readLine().split(" ");
            for (int j = 0; j<n; j++) {
                map[i][j] = Integer.parseInt(t[j]);
                if(map[i][j]<min){ min = map[i][j]; minx =j; miny =i; }
            }
        }
        answer =-1;
        ansmove=0;

        for(int i = 0; i<n; i++){
            for (int j = 0; j<n; j++) {
                ansmove = Math.max(dfs ( j , i, 1), ansmove);
            }
        }

        System.out.println(ansmove);

    }

    public static int dfs( int x, int y, int move ){


//        if(ansmove<move) {
//            answer =count;
//            ansmove=move;
//        }
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;// 초기화

        for (int i=0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if( nx>=0 && nx<n && ny>=0 &&ny<n && map[ny][nx]>map[y][x]){
//                System.out.println(nx+", "+ny);
                dp[y][x] = Math.max(dp[y][x], dfs(nx, ny,move+1) + 1);

                dfs( nx, ny, move+1);
            }
        }

        return dp[y][x];
    }
}
