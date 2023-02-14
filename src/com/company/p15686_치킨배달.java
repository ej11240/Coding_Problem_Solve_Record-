package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p15686_치킨배달 {
    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;
    public static ArrayList<Node> house;
    public static ArrayList<Node> chicken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        map = new int[n][n];
        int house_count =0;
        int chicken_count =0;
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i=0; i<n; i++){
            t = br.readLine().split(" ");
            for (int j =0; j<n; j++){
                map[i][j] = Integer.parseInt(t[j]);
                if(map[i][j]==1) {house_count++; house.add(new Node(i,j)); }
                if(map[i][j]==2) {chicken_count++; chicken.add(new Node(i,j)); }
            }
        }

        visited = new boolean[chicken_count];
        back(0,0);
        System.out.println(answer);
    }
    public static void back(int index, int count){
//        System.out.println(index);
        if(count==m){
//            System.out.println("id"+index);
            int total =0;
            for (int i=0; i<house.size(); i++){
                int min=Integer.MAX_VALUE;
                for (int j=0; j<chicken.size(); j++){
                    if(visited[j]) min = Math.min(min, Math.abs(house.get(i).x - chicken.get(j).x)
                            + Math.abs(house.get(i).y - chicken.get(j).y)); // 모든 집 ~ 치킨집 사이 거리중 최소값
                }
                total += min;
//                System.out.println("total"+total);
            }
            answer = Math.min(total, answer);
            return;
        }

        for (int i=index; i<chicken.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                back(i+1 , count+1);
                visited[i] = false;
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
