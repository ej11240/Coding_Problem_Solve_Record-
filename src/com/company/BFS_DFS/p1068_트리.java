package com.company.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class p1068_트리 {
    public static boolean[][] map;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        String[] t = bufferedReader.readLine().split(" ");
        map = new boolean[n][n];
        for (int i = 0; i<n; i++){
            int p = Integer.parseInt(t[i]);
            if(p!=-1)
                map[p][i] = true;
        }

        int start_node = Integer.parseInt(bufferedReader.readLine());
        if(start_node==-1) {
            System.out.println(0);
            return;
        }
        visited = new boolean[n];
        removed = new HashSet<>();
        dfs(start_node);

        int answer =0;
        for (int i = 0; i<n; i++){
            boolean is_leaf = false;
            for (int j = 0; j<n; j++){
//                System.out.print(map[i][j]+" ");
                if(map[i][j]) is_leaf=true;
            }
            if(!is_leaf && !removed.contains(i)){
//                System.out.print("=> leaf");
                ++answer;
            }
//            System.out.println();
        }
        System.out.println(answer);
    }

    public static HashSet<Integer> removed;
    public static boolean[] visited;

    public static void dfs(int start){
//        System.out.println(start);
        removed.add(start);

        for (int i = 0; i < n; i++){
            if(map[start][i]){
                dfs(i);
                map[start][i] = false;
            }
        }
        return;
    }
}
