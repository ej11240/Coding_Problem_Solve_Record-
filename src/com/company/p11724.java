package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p11724 {
    static boolean[] visited;
    static int[][] arr;
    static int n;

    public static void p11724(){
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        int m=sc.nextInt();

        arr = new int[1001][1001];
//        Arrays.fill(arr, false);

        for (int i=0; i<m; i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            arr[t1][t2]=1;
            arr[t2][t1]=1;
        }
        //대칭

        //dfs 탐색

        visited = new boolean[1001];

        Arrays.fill(visited,false);

        int c=0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i); c++;
            }
        }

        System.out.println(c);
    }

    public static void dfs(int s){
        visited[s]= true;
        for (int i=1; i<=n; i++){
//            System.out.println(i);
            if(arr[s][i]==1 && !visited[i] ){
                visited[i]=true;
                dfs(i);
            }
        }
    }
}
