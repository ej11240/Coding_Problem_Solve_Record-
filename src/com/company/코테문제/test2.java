package com.company.코테문제;
import java.io.*;
import java.util.*;

public class test2 {
    public static long target;
    public static long min;
    public static int endPoint;
//    public static boolean[][] visited ;
//    public static LinkedList<LinkedList<Integer>> visited;


    public static void main(String[] args){
        int[] q1 =new int[30000];
        int[] q2 =new int[30000];
        for( int i =0; i<30000; i++){
            q1[i]=(int)(Math.random() * 1000000000);
        }
        for( int i =0; i<30000; i++){
            q2[i]=(int)(Math.random() * 1000000000);
        }
//        int[] q1 ={3, 2, 7, 2};
//        int[] q2 = {4, 6, 5, 1};
        solution(q1,q2);
    }
    public static HashMap<Integer, ArrayList<Integer>> visited;
    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        target =0;
        endPoint = queue1.length;
        min =Long.MAX_VALUE;
        visited = new HashMap<>();
        int c =0;
        for( int i: queue1) {
            target+=i;
            ArrayList<Integer> t = new ArrayList<>();

            visited.put(c, t);
            c++;
        }
        System.out.println(visited.size());
        long sum1 = target;
        for( int i: queue2) {
            target+=i;
            ArrayList<Integer> t = new ArrayList<>();

            visited.put(c, t);
            c++;
        }

        target /= 2;

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
        ArrayList<Integer> t= new ArrayList<>();
//        t =visited.get(s);
        t.add(e);
        visited.remove(s);
        visited.put(s,t);

        while(!queue.isEmpty()){
            Node n = queue.poll();
            System.out.print(visited.get(0).size() );
            if(n.sum==target){
                min = min>n.count? n.count:min;
                System.out.print(" "+n.sum+" "+target+"."+n.count+"~ ");
            }

            //연산
//            System.out.println(visited.get(n.s+1));
            if(n.s+1<=2*endPoint-1 &&( visited.get(n.s+1)==null || !visited.get(n.s+1).contains(n.e))){
                long ts =0;
                if(n.s>endPoint-1){ ts = queue2[n.s-endPoint]; }else { ts = queue1[n.s];}
//                System.out.println((n.s+1)+","+n.e+","+n.sum+","+(n.sum-nlist.get(n.s+1))+" 요소:"+nlist.get(n.s+1)+","+(n.count+1)+" ");
                queue.add(new Node(n.s+1, n.e, n.sum-ts , n.count+1));
//                t = visited.get(n.s+1);
//                t.add(n.e);
//                visited.remove(n.s+1);
//                visited.put(n.s+1,t);
                visited.get(n.s+1).add(n.e);
//                System.out.println(visited.get(n.s+1).size());
            }
            else {
                if(n.s+1==endPoint &&( visited.get(0)==null  || !visited.get(0).contains(n.e))){
                    long ts =0;
                    if(n.s>endPoint-1){ ts = queue2[n.s-endPoint]; }else { ts = queue1[n.s];}
//                     System.out.println(0+","+n.e+","+n.sum+","+(n.sum-nlist.get(n.s))+" 요소:"+nlist.get(n.s)+","+(n.count+1)+" ");
                    queue.add(new Node(0, n.e, n.sum-ts , n.count+1));
//                    visited.get(0).add(n.e);
//                    t = visited.get(0);
//                    t.add(n.e);
//                    visited.remove(0);
//                    visited.put(0,t);
                    visited.get(0).add(n.e);
//                    System.out.println(visited.get(0).size());
                }
            }
            if(n.e+1<=2*endPoint-1 &&( visited.get(n.s)==null || !visited.get(n.s).contains(n.e+1))){
                long te =0;
                if(n.e+1>endPoint-1){ te = queue2[n.e-endPoint+1]; } else { te = queue1[n.e+1];}
//                 System.out.println(n.s+","+(n.e+1)+","+n.sum+","+(n.sum+nlist.get(n.e+1))+" 요소:"+nlist.get(n.e+1)+","+(n.count+1)+" ");
                queue.add(new Node(n.s, n.e+1, n.sum+te , n.count+1));
//                visited.get(n.s).add(n.e+1);
//                t = visited.get(n.s);
//                t.add(n.e+1);
//                visited.remove(n.s);
//                visited.put(n.s,t);
                visited.get(n.s).add(n.e+1);
//                System.out.println(visited.get(n.s).size());
            }
            else{
                if(n.e+1 == endPoint &&( visited.get(n.s)==null  || !visited.get(n.s).contains(0))){
//                    long te =0;
//                    if(n.e>endPoint-1){ te = queue2[0]; } else { te = queue1[n.e+1];}
//                     System.out.println(n.s+","+0+","+n.sum+","+(n.sum+nlist.get(0))+" 요소:"+nlist.get(0)+","+(n.count+1)+" ");
                    queue.add( new Node(n.s, 0, n.sum+queue1[0], n.count+1 ));
//                    visited.get(n.s).add(0);
//                    t = visited.get(n.s);
//                    t.add(0);
//                    visited.remove(n.s);
//                    visited.put(n.s,t);
                    visited.get(n.s).add(0);
//                    System.out.println(visited.get(n.s).size());
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
