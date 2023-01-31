package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class p13023_ABCDE {
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static boolean isable;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
//        System.out.println(n+" "+m);?

        list = new ArrayList[n];
        for (int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            t = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[n];
        int count = 0;
        isable = false;
        while (count<n){
            if (isable) break;
            visited = new boolean[n];
            dfs(count, 0);
            count++;
        }

        if(!isable) System.out.println(0);
        else System.out.println(1);
    }

    public static void dfs(int x, int depth){
        if(depth==4){
            isable = true;
            return;
        }

        visited[x] = true;

//        System.out.println(list[x].size());
        for (int i=0; i< list[x].size(); i++){
            int t = list[x].get(i);

            if (!visited[t]){
                dfs(t, depth+1);
            }
        }
        visited[x] = false;
    }
}