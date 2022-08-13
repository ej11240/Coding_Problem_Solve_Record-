package com.company.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 순열사이클 {
    static LinkedList<Integer>[] adjust ;
    static LinkedList<Integer> left;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase > 0) {
            N = Integer.parseInt(br.readLine());
            adjust = new LinkedList[N + 1];
            left = new LinkedList<>();
            visited = new boolean[N + 1];

            String[] s = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                adjust[i] = new LinkedList<Integer>();
                adjust[i].add(Integer.parseInt(s[i-1]));
                left.add(i);
            }

            int count = 0;
            while (!left.isEmpty()) {
//                System.out.println("====tc:"+testcase+", left:"+left);
                int start = left.get(0);
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                left.remove(left.indexOf(start));
                visited[start]=true;

                while (!queue.isEmpty()) {

                    int v = queue.poll();

                    Iterator<Integer> iter = adjust[v].listIterator();
                    while (iter.hasNext()) {
                        int w = iter.next();
                        if (!visited[w]) {
                            visited[w] = true;
                            left.remove(left.indexOf(w));
                            queue.add(w);
                        }
                    }

                }
            }
            System.out.println(count);
            testcase--;
        }
    }
}
