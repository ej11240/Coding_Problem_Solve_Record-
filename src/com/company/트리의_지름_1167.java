package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 트리의_지름_1167 {
    public static int v ;
    public static LinkedList<Node>[] graph ;
    public static int answer =-1;
    public static int maxn;
    public static void main(String[] args) throws IOException {
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        v=Integer.parseInt(bufferedReader.readLine());
        graph = new LinkedList[v + 1];
        maxn=-1;
        for (int i = 1; i <= v; i++) {
            graph[i] = new LinkedList<Node>();
        }
        for( int i = 0; i< v; i++){
            String[] t = bufferedReader.readLine().split(" ");
            int n1 = Integer.parseInt(t[0]);
            for (int j = 1; j<=(t.length-2)/2; j++){
                int n2 = Integer.parseInt(t[j*2-1]);
                int s = Integer.parseInt(t[j*2]);
                graph[n1].add(new Node(n2,s));

            }
        }



//        for( int i =1; i<=v; i++) {
//            Queue<Node> queue = new LinkedList<>();
//            queue.add(new Node(i,0));
//            boolean[] visited  = new boolean[v+1];
//            visited[i] = true;
//            int t = bfs(queue, visited);
//            answer= answer<t?t:answer ;
//
//        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        boolean[] visited  = new boolean[v+1];
        visited[1] = true;
        System.out.println(bfs(queue, visited));

        System.out.println(queue.size());
        queue.add(new Node(maxn,0));
        System.out.println(maxn);
        visited = new boolean[v+1];

        System.out.println(bfs(queue,visited));
    }
    public static int bfs(Queue<Node> queue, boolean[] visited){
        int max=-1;

        while (!queue.isEmpty()){
            Node n = queue.poll();
            maxn = max<n.sum ? n.n :maxn;
            max = max<n.sum ? n.sum :max;

            for (Node tn: graph[n.n]){
                if(!visited[tn.n]){
                    queue.add(new Node(tn.n, n.sum+tn.sum));
                    visited[tn.n] =true;
                }
            }
        }

        return max;
    }
    public static class Node{
        int n; int sum;
        public Node(int n, int sum){
            this.n =n;
            this.sum=sum;
        }
    }
}
