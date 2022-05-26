package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class 스티커9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int count = Integer.parseInt(t[0]);
        while (count > 0) {

            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n+1];
            int[][] cost = new int[2][n+1];
            for(int j =0; j<2; j++) {
                t = br.readLine().split(" ");
                for (int i = 1; i <= n; i++) {
                    cost[j][i] = Integer.parseInt(t[i-1]);
                }
            }
            dp[0][1]=cost[0][1];
            dp[1][1] =cost[1][1];
            for (int i = 2; i <= n; i++) {
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + cost[1][i];
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + cost[0][i];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
            count--;
        }
    }


//    public static int[] dx ={0,1,0,-1};
//    public static int[] dy ={-1,0,1,0};
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] t = br.readLine().split(" ");
//        int count=Integer.parseInt(t[0]);
//        while (count>0){
//            int answer =0;
//            int n = Integer.parseInt(br.readLine());
//            boolean[][] visited = new boolean[2][n];
//            ArrayList<Sticker> list = new ArrayList<>();
//            for(int j =0; j<2; j++) {
//                t = br.readLine().split(" ");
//                for (int i = 0; i < n; i++) {
//                    list.add(new Sticker(i, j, Integer.parseInt(t[i])));
//                }
//            }
//            Collections.sort(list);
//            for(Sticker s : list) {
//                if(!visited[s.y][s.x]){
//                    answer+=s.value;
//                    for (int i =0; i<4; i++){
//                        int nx = s.x+ dx[i];
//                        int ny = s.y+ dy[i];
//                        if( ny>=0 && ny<=1 && nx>=0 && nx<=n-1){
//                            visited[ny][nx] = true;
//                        }
//                    }
//                }
//            }
//            System.out.println(answer);
//            count--;
//        }
//
//    }
//    static class Sticker implements Comparable<Sticker>{
//        int x,y,value ;
//        Sticker (int x, int y, int value){
//            this.x = x;
//            this.y = y;
//            this.value =value;
//        }
//
//        @Override
//        public int compareTo(Sticker s){
//            return s.value-this.value;
//        }
//    }
}
