package com.company.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 스타트링크5014 {
    public static int f,s,g,u,d, answer;
//    public static void main(String[] arg) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] t = bufferedReader.readLine().split(" ");
//        f = Integer.parseInt(t[0]);
//        s = Integer.parseInt(t[1]);
//        g = Integer.parseInt(t[2]);
//        u = Integer.parseInt(t[3]);
//        d = Integer.parseInt(t[4]);
//        answer = Integer.MAX_VALUE;
//
//        dfs(s,0);
////        boolean[] visited = new boolean[f];
////
////        Queue<Floor> queue = new LinkedList<>();
////        queue.add(new Floor())
//        System.out.println(answer);
//    }
//    public static void dfs(int floor , int count){
//        if(floor==g) {
//            answer = answer>count ? count : answer;
//            return;
//        }
//        if(count>answer) return;
//        System.out.println(floor);
//
//        if(floor+u<=f) dfs(floor+u, ++count);
//        if(floor-d>0) dfs(floor-d, ++count);
//
//        return;
//    }
//    public static class Floor{
//        int n, count;
//        public Floor(int n, int count){
//            this.n = n;
//            this.count = count;
//        }
//    }


    public static boolean[] visited;
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        f = Integer.parseInt(t[0]);
        s = Integer.parseInt(t[1]);
        g = Integer.parseInt(t[2]);
        u = Integer.parseInt(t[3]);
        d = Integer.parseInt(t[4]);
        answer = Integer.MAX_VALUE;

        visited = new boolean[f+1];
        visited[s]=true;
        bfs();
//        answer= Integer.MAX_VALUE;
//        dfs(s,0);
        if(answer==Integer.MAX_VALUE) System.out.println("use the stairs");
        else System.out.println(answer);
    }
    public static void bfs(){
        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(s,0));

        while (!queue.isEmpty()){
            Floor floor = queue.poll();
            if(floor.n==g) answer = answer>floor.count ? floor.count : answer;
            System.out.println(floor.n+" "+ floor.count);

            if(floor.n+u<=f && u!=0 && !visited[floor.n+u]) {
                visited[floor.n+u] =true;
                queue.add(new Floor(floor.n+u, floor.count+1));
            }
            if(floor.n-d>0 && d!=0 && floor.n-d<=f && !visited[floor.n-d]) {
                visited[floor.n-d] =true;
                queue.add(new Floor(floor.n-d, floor.count+1));
            }

        }
    }
    public static class Floor{
        int n, count;
        public Floor(int n, int count){
            this.n = n;
            this.count = count;
        }
    }

}
