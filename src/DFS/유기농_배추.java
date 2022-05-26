package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 유기농_배추 {
    static public int[][] map; // [y][x] 가 됨.
    static public boolean[][] visited; //마찬가지로 [y][x]
    static public LinkedList<ArrayList<Integer>> points;
    static public int count =0;

    static public int[] gx = {1,-1,0,0};
    static public int[] gy = {0,0,-1,1};
    static public int  map_x_size=0;
    static public int  map_y_size=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> answer = new LinkedList<>();

        while (test_case!=0) {
//            System.out.println("============="+test_case+"============");
            String[] t = bufferedReader.readLine().split(" ");

            count=0;
            map_x_size = Integer.parseInt(t[0]);
            map_y_size = Integer.parseInt(t[1]);
            int K = Integer.parseInt(t[2]);

            map = new int[map_y_size+1][map_x_size+1];
            visited = new boolean[map_y_size+1][map_x_size+1];
            points = new LinkedList<>();

            for (int i = 0; i < K; i++) {
                String[] s = bufferedReader.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                map[b][a] = 1;

                ArrayList<Integer> p = new ArrayList<>();
                p.add(b);
                p.add(a); //points 안에 배추의 위치가 { {y1,x1}, {y2,x2}, ...  }이렇게 저장됨

                points.add(p);
            }

            while (points.size() != 0) { //만약 배추가 아예 없는 밭에서는 그냥 while문 실행 없이 초기에 빠져나감 -> 에러 없음
                ArrayList<Integer> xy = points.get(0); // 아놔 .... 이거 point.pop() 했다가 틀렸다고 뜸...

                int x = xy.get(1);
                int y = xy.get(0);

                DFS(y, x);

                count++;

            }

            test_case--;
            answer.add(count);
        }
        for (int i: answer)
            System.out.println(i);
    }

    static public void DFS(int y,int x){
        System.out.println(points);
        remove_from_points(y,x);
        System.out.println(points);

        System.out.println(y+", "+x+", count:"+count);
        visited[y][x] = true;

        for (int i =0; i<4; i++){
            int next_y = y+gy[i];
            int next_x = x+gx[i];
            if(next_x<0 || next_y<0 || next_y>map_y_size-1 || next_x>map_x_size-1 ) continue;
            if(map[next_y][next_x]==1){
                if(visited[next_y][next_x]==false){
                    DFS(next_y,next_x);
                }
            }
        }
    }

    static public void remove_from_points(int y, int x){
        ArrayList<Integer> xy = new ArrayList<>();
        xy.add(y); xy.add(x);
//        System.out.println(y+", "+x);
        int  ct = 0;
        // ConcurrentModificationException 에러로 인해 Iterator 사용

        for (Iterator<ArrayList<Integer>> iterator = points.iterator(); iterator.hasNext();){
            ArrayList<Integer> al = iterator.next();
            if(al.containsAll(xy)){
                System.out.println("xy:"+xy+", "+al);
                iterator.remove();
                break;
            }
        }

    }
}
