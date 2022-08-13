package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15649_N과_M {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        list = new int[m+1];
        visited = new boolean[n+1];
        dfs(0);
    }
    public static int n,m;
    public static int[] list ;
    public static boolean[] visited ;
    public static void dfs(int dp)
    {
        if(dp == m)
        {
            for(int i = 0; i < m; i++)
                System.out.print( list[i] +" ");
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                list[dp] = i;
                dfs(dp+1);
                visited[i] = false;
            }
        }
    }

}
