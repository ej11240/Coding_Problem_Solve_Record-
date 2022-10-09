package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2636_치즈 {
    static class Point{
        int row;
        int col;
        public Point(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r + 2][c + 2];
        int totalCheese = 0;
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '1') {
                    totalCheese++;
                }
            }
        }

        if (totalCheese == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        LinkedList<Point> outerAir = new LinkedList<>();
        boolean[][] visited = new boolean[r + 2][c + 2];
        visited[1][1] = true;
        outerAir.addLast(new Point(1, 1));
        int time = 0;
        int remain = totalCheese;
        while(!outerAir.isEmpty()) {
            time++;
            remain = totalCheese;
            LinkedList<Point> airsideCheese = new LinkedList<>();
            while(!outerAir.isEmpty()) {
                Point now = outerAir.pollFirst();
                for(int d = 0; d < 4; d++) {
                    int nextRow = now.row + dr[d];
                    int nextCol = now.col + dc[d];
                    if (visited[nextRow][nextCol]) continue;
                    visited[nextRow][nextCol] = true;
                    if (map[nextRow][nextCol] == '0') {
                        outerAir.addLast(new Point(nextRow, nextCol));
                    }
                    else if(map[nextRow][nextCol] == '1') {
                        airsideCheese.addLast(new Point(nextRow, nextCol));
                        if (--totalCheese == 0) {
                            System.out.println(time);
                            System.out.println(remain);
                            return;
                        }
                    }
                }
            }
            outerAir = airsideCheese;
        }

    }
}
//    public static int dx[] = {-1, 1, 0, 0};
//    public static int dy[] = {0, 0, -1, 1};
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] t = bufferedReader.readLine().split(" ");
//        int w,h;
//        h = Integer.parseInt(t[0]);
//        w = Integer.parseInt(t[1]);
//        int[][] map = new int[h][w];
//        for (int i =0; i<h; i++){
//            t = bufferedReader.readLine().split(" ");
//            for (int j =0; j<w; j++){
//                map[i][j] = Integer.parseInt(t[j]);
//            }
//        }
//
//        //구멍인지 판별
//        //2중 포문으로 상하좌우에 공기 있는지 확인
//
//        int count =0;
//        int before =0;
//        int hour=0;
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(0,0));
//        boolean[][] visited = new boolean[h][w];
//        visited[0][0] = true;
//        while (true){
//            boolean isleft = false;
//
//            while (!queue.isEmpty()){
//                Point p = queue.poll();
//                int y = p.y;
//                int x = p.x;
//
//                for (int i=0; i<4;i++){
//                    int nx = x+dx[i];
//                    int ny = y+dy[i];
//
//                    if(nx>=0 && ny<h && ny>=0 && nx<w && !visited[ny][nx]){
//                        if(map[ny][nx]==0){
//                            queue.add(new Point(nx,ny));
//                        }
//                        else {
//                            map[ny][nx] = 0;
//                            count++;
//                        }
//                        visited[ny][nx] = true;
//
//                    }
//                }
//            }
//
//            if(count==0) {
//                System.out.println(hour); System.out.println(before);
//                break;
//            }
//            else {
//                before = count;
//            }
//
//            hour++;
//        }
//
//
//    }
//    static class Point {
//        int y, x;
//        public Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//
//    }
//}
