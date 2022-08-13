package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9466_텀_프로젝트 {
    public static int n, c;
    public static boolean[] visited;
    public static boolean[] done;
    public static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int case_count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i<case_count; i++){
            n = Integer.parseInt(bufferedReader.readLine());
            graph = new int[n+1];
            String[] t = bufferedReader.readLine().split(" ");
            for (int j = 1; j<=n; j++){
                graph[j] = Integer.parseInt(t[j-1]);
            }
            c = 0;
            done = new boolean[n+1];
            visited = new boolean[n+1];
            for (int j = 1; j <= n; j++){
                if(!visited[j]) {
                    dfs(j);
                }
            }
            System.out.println(n-c);
        }
    }
    public static void dfs(int node){
        visited[node] = true;
        int next = graph[node];
        if(!visited[next])
            dfs(next);
        else if(!done[next]){
            for (int i = next; i!=node; i=graph[i])
                c++;
            c++;
        }

        done[node] = true;
    }
}
