package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17135_캐슬디펜스 {
    public static int n;
    public static int m;
    public static int d;
    public static int[][] castle;
    public static int[] archer;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        d = Integer.parseInt(t[2]);

        castle = new int[n][m];
        archer = new int[3];
        answer = 0;
        for (int i = 0; i < n; i++) {
            t = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(t[j]);
            }

        }
        dfs(0, 0, new boolean[m]);
        System.out.println(answer);
    }

    static Node findMinDist(int[][] temp, int bow) {
        Node pos = new Node(-1, -1);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(temp[j][i] == 1) {
                    int dist = Math.abs(bow - i) + Math.abs(n - j);
                    if(min > dist && dist<= d) {
                        min = dist;
                        pos.x = i;
                        pos.y = j;
                    }
                }
            }
        }

        return pos;
    }

    public static void dfs(int index, int count, boolean[] visit) {
        if (count >= 3) {
            int sum = 0;
            int[][] temp = new int[n][m];

            for (int i = 0; i < n; i++) {
                System.arraycopy(castle[i], 0, temp[i], 0, m);
            }

            for (int i = 0; i < n; i++) { // N 번만큼 down...
                Node[] die = new Node[3];

                for (int j = 0; j < 3; j++) {
                    die[j] = findMinDist(temp, archer[j]);
                }

                for (int j = 0; j < 3; j++) {
                    Node cur = die[j];

                    if (cur.x == -1)
                        continue;

                    if (temp[cur.y][cur.x] == 1) {
                        temp[cur.y][cur.x] = 0;
                        sum++;
                    }
                }

                for (int j = n - 1; j > 0; j--) {
                }
            }

            answer = Math.max(sum, answer);

            return;
        }

        for (int i = index; i < m; i++) {
            if (!visit[i]) {
                visit[i] = true;
                archer[count] = i;
                dfs(i + 1, count + 1, visit);
                visit[i] = false;
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
