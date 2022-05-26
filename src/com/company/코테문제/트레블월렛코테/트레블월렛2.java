package com.company.코테문제.트레블월렛코테;
import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class 트레블월렛2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int a = Integer.parseInt(bufferedReader.readLine().trim());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        int c = Integer.parseInt(bufferedReader.readLine().trim());

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        String result =  isPossible(a, b, c, d);
        System.out.println(result);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
    public static String isPossible(int a, int b, int c, int d) {
        String answer ="No";

        boolean[][] visited = new boolean[1001][1001];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(a,b,1));
        visited[b][a] = true;

        while (!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x==c && p.y==d) {
                answer="Yes";
                break;
            }
//            System.out.println();

            if(p.x+p.y<1001 && p.y<1001 && !visited[p.y][p.x+p.y]){
                visited[p.y][p.x+p.y]=true;
                queue.add(new Point(p.x+p.y, p.y, p.count+1));
            }
            if(p.x<1001 && p.y+p.x<1001 && !visited[p.y+p.x][p.x]){
                visited[p.y+p.x][p.x]=true;
                queue.add(new Point(p.x, p.y+p.x, p.count+1));
            }
        }

        return answer;
    }
    public static class Point{
        int x,y, count;
        public Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}


