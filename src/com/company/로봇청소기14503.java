package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로봇청소기14503 {
    public static int n,m;
    public static int[][] map;
    public static int[] dx ={0,1,0,-1};
    public static int[] dy ={-1,0,1,0};
    public static int count;

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bf.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        map = new int[n][m];

        t = bf.readLine().split(" ");
        int x = Integer.parseInt(t[1]);
        int y = Integer.parseInt(t[0]);
        int cd = Integer.parseInt(t[2]);

        for( int i = 0; i<n; i++ ){
            t = bf.readLine().split(" ");
            for( int j = 0; j<m; j++)
                map[i][j] = Integer.parseInt(t[j]);
        }

        count=1;
        dfs( x, y, cd );
        System.out.println(count);
    }
    public static void dfs(int x, int y, int cd){

        map[y][x] = 2;
        System.out.println(x+","+y);
        for( int i = 0; i<n; i++ ){
            for( int j = 0; j<m; j++)
                System.out.print(map[i][j]+" ");
            System.out.println("");
        }
        System.out.println("");

        for(int i =0; i<4; i++){
            cd= (cd+3)%4;
            int nx = dx[cd]+x;
            int ny = dy[cd]+y;
            if(nx>=0 && ny>=0 && ny<n && nx<m && map[ny][nx]==0){
                count++;
                dfs(nx,ny,cd);
//                break;
                return;
            }
        }

        int back = (cd+2)%4;
        int nx = dx[back]+x;
        int ny = dy[back]+y;
        if(nx>=0 && ny>=0 && nx<m && ny<n && map[ny][nx]!=1){
            dfs(nx,ny,cd);
        }


    }
}
