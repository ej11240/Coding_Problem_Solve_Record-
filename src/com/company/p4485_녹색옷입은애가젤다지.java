package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p4485_녹색옷입은애가젤다지 {
    public static int n;
    public static int arr[][];
    public static int dist[][];
    public static final int INF = Integer.MAX_VALUE;
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String tt = br.readLine();
            if (tt.isBlank()) break;
            n = Integer.parseInt(tt);
            int[][] arr = new int[125][125];
            for (int i = 0; i < n; i++) {
                String[] t = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(t[j]);
                    dist[i][j] = INF;
                }
            }

            dij(0,0);

        }
    }

    public static void dij(int x, int y){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }

        Queue<Integer> queue =new LinkedList<>();


    }
}
