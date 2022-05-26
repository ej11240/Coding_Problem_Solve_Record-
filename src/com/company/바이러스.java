package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바이러스 {
    static int[][] graph;
    public static boolean[] visited;
    public static int count =0;
//    {false, false true, false true flase}

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        int edge = Integer.parseInt(reader.readLine());

        graph = new int[size+1][size+1]; //초기값은 0으로 설정하기 위해 기본 타입(Primary Type)을 사용함.

        visited = new boolean[size+1];//초기값 설정 false

        for(int i= 0; i<edge; i++){
            String[] s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        DFS(1);

        System.out.println(count-1);

    }

    public static void DFS(int v){
        visited[v] = true;

//        System.out.println(v);

        count++;

        int c =0;
        for(int i:graph[v]){
            if(i==1){
                if(visited[c]==false)
                    DFS(c);
            }
            c++;
        }
    }
}
