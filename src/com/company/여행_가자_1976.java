package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class 여행_가자_1976 {
    public static int N;
    public static int M;
    public static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        map= new boolean[N][N];
        for (int i = 0; i<N; i++) {
            String[] t = bufferedReader.readLine().split(" ");
            for (int j = 0; j<N; j++) {
                if(Integer.parseInt(t[j])==1)
                    map[i][j] = true;
            }
            map[i][i]=true;
        }
        for (int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                for (int k=0; k<N; k++){
                    if(map[j][i] && map[i][k]) {map[j][k] = true; map[k][j]=true;}
                }
            }
        }


        String[] t = bufferedReader.readLine().split(" ");
        boolean answer =true;
        for (int i = 1; i< t.length; i++){
            int start = Integer.parseInt(t[i-1])-1;
            int end = Integer.parseInt(t[i])-1;
            if(!map[start][end] && !map[end][start]) answer=false;
        }
        if(answer) System.out.println("YES");
        else System.out.println("NO");

    }

    public static boolean bfs(int start , int end){
        boolean able=false;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[N];
        visited[start]=true;

        while (!queue.isEmpty()){
            int n = queue.poll();
            if(n==end) {
                able=true;
                break;
            }
            for (int i = 0; i<N; i++){
                if(map[n][i]==true){
                    int nn =i;
                    if(visited[nn]==false) {
                        queue.add(nn);
                        visited[nn] = true;
                    }
                }
            }

        }

        return able;
    }
}
