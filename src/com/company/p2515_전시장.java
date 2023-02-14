package com.company;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class p2515_전시장 {

    public static class Node implements Comparable<Node>{
        int h,c;
        public Node(int h, int c){
            this.h=h;
            this.c=c;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            if(o.h==h) return c - o.c;
            else return h-o.h;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");

        int N = Integer.parseInt(t[0]);
        int S = Integer.parseInt(t[1]);

        Node value[] = new Node[N];
        for(int i=0; i<N; i++){
            t = br.readLine().split(" ");
            value[i] = new Node(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
        }

        Arrays.sort(value);

        //for(int i=0; i<N; i++)
        //	System.out.println(value[i].h + " " + value[i].c);

        int dp[] = new int[N];
        dp[0] = value[0].c;
        int index=0;
        int max=0;
        int ans=dp[0];
        for(int i=1; i<N; i++){
//            f
            while (value[index].h <=value[i].h-S){
                max = Math.max(max, dp[index]);
                index++;
            }
            dp[i] = max + value[i].c;
            max = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}