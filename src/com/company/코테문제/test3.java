package com.company.코테문제;
import java.io.*;
import java.util.*;

public class test3 {
    public static long target;
    public static long min;
    public static int endPoint;

    public static void main(String[] args){
//        int[] q1 =new int[300000];
//        int[] q2 =new int[300000];
//        for( int i =0; i<300000; i++){
//            q1[i]=(int)(Math.random() * 1000000000);
//        }
//        for( int i =0; i<300000; i++){
//            q2[i]=(int)(Math.random() * 1000000000);
//        }
                int[] q1 ={3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};
        solution(q1,q2);
    }
    public static boolean[][] visited ;
    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        target =0;
        endPoint = queue1.length;
        min =Long.MAX_VALUE;
        visited = new boolean[2*queue1.length][2*queue1.length];


        for( int i: queue1) {
            target+=i;
        }
        long sum1 = target;
        for( int i: queue2) {
            target+=i;
//            nlist.add((long)i);
        }

        target /= 2;
        // for( int i=0; i<nlist.size(); i++){ System.out.print(nlist.get(i));}

        bfs(sum1, queue1, queue2);
        answer = (int)min;
        if(min==Integer.MAX_VALUE) answer =-1;
        System.out.println(answer);
        return answer;
    }
    public static void bfs(long sum1, int[] queue1, int[] queue2){
        int s = 0; int e = endPoint-1; long sum = sum1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s,e,sum, 0));
        visited[s][e] = true;

        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.sum==target){
                min = min>n.count? n.count:min;
//                 for( int i = n.s; i<=n.e; i++ ) System.out.print("succ"+nlist.get(i));
                System.out.print(" "+n.sum+" "+target+"."+n.count+"~ ");
            }

            //연산
            if(n.s+1<=2*endPoint-1 && !visited[n.s+1][n.e]){
                long ts =0;
                if(n.s>endPoint-1){ ts = queue2[n.s-endPoint]; }else { ts = queue1[n.s];}
//                System.out.println((n.s+1)+","+n.e+","+n.sum+","+(n.sum-nlist.get(n.s+1))+" 요소:"+nlist.get(n.s+1)+","+(n.count+1)+" ");
                queue.add(new Node(n.s+1, n.e, n.sum-ts , n.count+1));
                visited[n.s+1][n.e] = true;
            }
            else {
                if(n.s+1==endPoint  && !visited[0][n.e]){
                    long ts =0;
                    if(n.s>endPoint-1){ ts = queue2[n.s-endPoint]; }else { ts = queue1[n.s];}
//                     System.out.println(0+","+n.e+","+n.sum+","+(n.sum-nlist.get(n.s))+" 요소:"+nlist.get(n.s)+","+(n.count+1)+" ");
                    queue.add(new Node(0, n.e, n.sum-ts , n.count+1));
                    visited[0][n.e] = true;
                }
            }
            if(n.e+1<=2*endPoint-1 && !visited[n.s][n.e+1]){
                long te =0;
                if(n.e+1>endPoint-1){ te = queue2[n.e-endPoint+1]; } else { te = queue1[n.e+1];}
//                 System.out.println(n.s+","+(n.e+1)+","+n.sum+","+(n.sum+nlist.get(n.e+1))+" 요소:"+nlist.get(n.e+1)+","+(n.count+1)+" ");
                queue.add(new Node(n.s, n.e+1, n.sum+te , n.count+1));
                visited[n.s][n.e+1] = true;
            }
            else{
                if(n.e+1 == endPoint  && !visited[n.s][0]){
//                    long te =0;
//                    if(n.e>endPoint-1){ te = queue2[0]; } else { te = queue1[n.e+1];}
//                     System.out.println(n.s+","+0+","+n.sum+","+(n.sum+nlist.get(0))+" 요소:"+nlist.get(0)+","+(n.count+1)+" ");
                    queue.add( new Node(n.s, 0, n.sum+queue1[0], n.count+1 ));
                    visited[n.s][0] = true;
                }
            }
        }
    }
    static class Node{
        int s, e;
        long sum, count;
        public Node(int s, int e, long sum, long count){
            this.s =s;
            this.e =e;
            this.sum = sum;
            this.count = count;
        }
    }

}
