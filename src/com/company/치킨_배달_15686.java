package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 치킨_배달_15686 {
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t= bufferedReader.readLine().split(" ");
        List<Point> house = new LinkedList<>();
        List<Point> chicken = new LinkedList<>();
        int n= Integer.parseInt(t[0]);
        map = new int[n][n];
        int m = Integer.parseInt(t[1]);
        for( int i = 0; i<n; i++){
            t = bufferedReader.readLine().split(" ");
            for (int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(t[j]);
                if(map[i][j]==1)
                    house.add(new Point(j,i));
                if(map[i][j]==2)
                    chicken.add(new Point(j,i));

            }
        }
        int[] chicken_distance = new int[chicken.size()];
        int ans = Integer.MAX_VALUE;
        int i =0;
        for( Point delch: chicken) {
            int sum= 0;
            for (Point h : house) {
                int distance = Integer.MAX_VALUE;
                for (Point c : chicken) {
                    if(c.x!=delch.x && c.y!=delch.y) {
                        int curdis = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                        distance = distance > curdis ? curdis : distance;
                    }
                }
//                chicken_distance[i] = distance;
                sum+=distance;
            }
//            chicken_distance[i]
            System.out.println(sum);
            ans = sum>ans ? ans:sum;
            i++;
        }
        for ( i=0; i<chicken_distance.length; i++)
            System.out.println(chicken_distance[i]);

    }
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
