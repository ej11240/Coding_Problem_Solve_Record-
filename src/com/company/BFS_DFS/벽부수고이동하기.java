package com.company.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기 {
    public static int[][] map;
    public static int n;
    public static int m;
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] t = b.readLine().split(" ");
        n = Integer.parseInt(t[0]); m = Integer.parseInt(t[1]);
        map = new int[n][m];

        for(int i = 0; i<n; i++){
            t = b.readLine().split("");
            for (int j =0 ; j<m; j++){
                map[i][j]=Integer.parseInt(t[j]);
            }
        }

        bfs();

    }

    public static void bfs(){
        Queue<Point> p = new LinkedList<>();
        p.add(new Point(0,0,1,false));

        boolean[][][] visited = new boolean[n][m][2];

        while(!p.isEmpty()){
            Point point = p.poll();

            if (point.y == n - 1 && point.x == m - 1) {
                System.out.println(point.count);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = point.x;
                int ny = point.y;
                int nc = point.count+1;

                if( nx>=0 && nx<m && ny>=0 && ny<n ){
                    //벽일 경우
                        //아직 한번도 안부숨(breaked=false)면
                            // (false로 부여) visited[][][0]=true로 할당
                        //이미 부숨(breaked=true)면
                        // false 부여, visited[][][1]=true 할당

                    //벽이 아닐 경우
                        //아직 한번도 안부숨(breaked=false)면
                            // (false로 부여) visited[][][0]=true로 할당
                        //이미 부숨(breaked=true)면
                            // false 부여, visited[][][1]=true 할당
                }
            }

//            for(int i = 0; i < 4; i++){
//                int nx = point.x + dx[i];
//                int ny = point.y + dy[i];
//                int nc = point.count +1;
//
//                if( nx>=0 && nx<m && ny>=0 && ny<n ){
//                    if(map[ny][nx]==0){ // 벽이 아니면
//                        System.out.println("nx:"+nx+", ny:"+ny+", nc:"+nc);
//                        if(!point.breaked && !visited[ny][nx][0]) { // 부신 벽이 여태까지 없었으면
//                            p.add(new Point(nx, ny, nc, false));
//                            visited[ny][nx][0] = true;
//                        }else if(point.breaked && !visited[ny][nx][1]){ // 벽을 한번 부신 적이 있으면
//                            p.add(new Point(nx, ny, nc, true));
//                            visited[ny][nx][1] = true;
//                        }
//
//                    }else if(map[ny][nx]==1){ // 벽이면
//
//                        if(!point.breaked){ // 한번도 벽을 부순적이 없다면 부순다~
//                            p.add(new Point(nx, ny, nc, true));
//                            visited[ny][nx][1] = true;
//                        }
//                        // 한번 부순 적이 있다면 또 부수고 갈 수 없기 때문에 pass
//                    }
//                }
//            }
        }
    }



}

class Point{
    int x;
    int y;
    int count;
    boolean breaked;

    public Point(int x, int y,int count,boolean breaked){
        this.x = x;
        this.y = y;
        this.count = count;
        this.breaked =breaked;
    }

    public void setBreaked(){
        this.breaked = true;
    }
}
