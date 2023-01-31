package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test{
    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, minTime;
    static int[][] arr, originArr;
    static int[] num;
    static List<Node> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        originArr = new int[N][N];
        arr = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(str[j]);
                originArr[i][j] = n;
                arr[i][j] = n;
                if (n == 1) {
                    originArr[i][j] = -1;
                    arr[i][j] = -1;
                } else if (n == 2) {
                    originArr[i][j] = -1;
                    arr[i][j] = -1;
                    virus.add(new Node(i, j));
                }
            }
        }

        minTime = Integer.MAX_VALUE;

        num = new int[M];
        bt(0, virus.size());

        System.out.println(minTime);
    }

    static void bt(int cnt, int size) {
        if (cnt == M) {
            Queue<Node> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            for (int i : num) {
                System.out.print(i + " ");
                Node node = virus.get(i - 1);
                arr[node.x][node.y] = 0;
                q.add(node);
                visited[node.x][node.y] = true;
            }
            System.out.println();

            int res = bfs(q, visited);
            minTime = Math.min(minTime, res);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = originArr[i][j];
                }
            }

            return;
        }

        for (int i = 1; i <= size; i++) {
            if (cnt > 0 && num[cnt - 1] >= i) continue;
            num[cnt] = i;
            bt(cnt + 1, size);
        }
    }

    static int bfs(Queue<Node> q, boolean[][] visited) {
        System.out.println("!!!!!!!!!!!");
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + moveX[i];
                int y = node.y + moveY[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (arr[x][y] == -1) continue;

                    if (visited[x][y]) continue;
                    visited[x][y] = true;

                    arr[x][y] = arr[node.x][node.y] + 1;
                    q.add(new Node(x, y, node.time + 1));
                }
            }
        }

        return getMax(N);
    }

    private static int getMax(int N) {
        int max = 0;
//        boolean isZero = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, arr[i][j]);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("max = " + max);
        return max;
    }
}