package com.company.코테문제;
import java.io.*;
import java.util.*;
import java.math.*;

public class test {
    public static void main(String[] args){
        HashMap< Integer,ArrayList<Integer>> s = new HashMap();
        ArrayList<Integer> d =new ArrayList<>();
        ArrayList<Integer> t =new ArrayList<>();
        d.add(2);
        s.put(0,d);
        t.add(3);
        s.put(1,t);
//        s.put(0, s.get(0).add(3));
        s.get(0).add(1);
        s.get(0).add(5);

        for (int i = 0; i< s.size(); i++){
            for (int j = 0; j<s.get(i).size(); j++)
                System.out.println(s.get(i).get(j));
        }
    }
}
//
//    public static LinkedList<Long> nlist;
//    public static BigInteger target;
//    public static long min;
//    public static int endPoint;
//    public static boolean[][] visited ;
//    public static void main(String[] args){
//        int[] q1 ={3, 2, 7, 2};
//        int[] q2 = {4, 6, 5, 1};
//        solution(q1,q2);
//    }
//    public static int solution(int[] queue1, int[] queue2) {
//        int answer = -2;
//        target =BigInteger.valueOf(0);
//        endPoint = queue1.length;
//        min =Long.MAX_VALUE;
//        visited = new boolean[2*queue1.length][2*queue1.length];
//        nlist = new LinkedList<>();
//        for( int i: queue1) { target.add(BigInteger.valueOf(i)); nlist.add((long)i); }
//        BigInteger sum1 = target;
//        for( int i: queue2) { target.add(BigInteger.valueOf(i)); nlist.add((long)i); }
//        BigInteger sum2 =  target.subtract(sum1);
//        target.divide( BigInteger.valueOf(2));
//        // for( int i=0; i<nlist.size(); i++){ System.out.print(nlist.get(i));}
//
//        bfs(sum1);
//        answer = (int)min;
//        if(min==Integer.MAX_VALUE) answer =-1;
//        System.out.println(answer);
//        return answer;
//    }
//    public static void bfs(BigInteger sum1){
//        int s = 0; int e = endPoint-1; BigInteger sum = sum1;
//        Queue<Node> queue = new LinkedList<>();
//        // System.out.print(sum );
//        queue.add(new Node(s,e,sum, 0));
//        visited[s][e] = true;
//
//        while(!queue.isEmpty()){
//            Node n = queue.poll();
//            // System.out.print();
//            if(n.sum==target){
//                min = min>n.count? n.count:min;
//                for( int i = n.s; i<=n.e; i++ ) System.out.print("succ"+nlist.get(i));
//                System.out.print(" "+n.sum+" "+target+"."+n.count+"~ ");
//            }
//
//
//            //연산
//            if(n.s+1<=2*endPoint-1 && !visited[n.s+1][n.e]){
//                System.out.println((n.s+1)+","+n.e+","+n.sum+","+(n.sum-nlist.get(n.s+1))+" 요소:"+nlist.get(n.s+1)+","+(n.count+1)+" ");
//                queue.add(new Node(n.s+1, n.e, n.sum.subtract(BigInteger.valueOf(nlist.get(n.s))) , n.count+1));
//                visited[n.s+1][n.e] = true;
//            }
//            else {
//                if(n.s+1==endPoint  && !visited[0][n.e]){
//                    System.out.println(0+","+n.e+","+n.sum+","+(n.sum-nlist.get(n.s))+" 요소:"+nlist.get(n.s)+","+(n.count+1)+" ");
//                    queue.add(new Node(0, n.e, n.sum.subtract(BigInteger.valueOf(nlist.get(n.s))) , n.count+1));
//                    visited[0][n.e] = true;
//                }
//            }
//            if(n.e+1<=2*endPoint-1 && !visited[n.s][n.e+1]){
//                // System.out.println(n.s+","+(n.e+1)+","+n.sum+","+(n.sum+nlist.get(n.e+1))+" 요소:"+nlist.get(n.e+1)+","+(n.count+1)+" ");
//                queue.add(new Node(n.s, n.e+1, n.sum.add(BigInteger.valueOf(nlist.get(n.e+1))) , n.count+1));
//                visited[n.s][n.e+1] = true;
//            }
//            else{
//                if(n.e+1 == endPoint  && !visited[n.s][0]){
//                    // System.out.println(n.s+","+0+","+n.sum+","+(n.sum+nlist.get(0))+" 요소:"+nlist.get(0)+","+(n.count+1)+" ");
//                    queue.add( new Node(n.s, 0, n.sum.add(BigInteger.valueOf(nlist.get(0))), n.count+1 ));
//                    visited[n.s][0] = true;
//                }
//            }
//        }
//    }
//    static class Node{
//        int s, e;
//        BigInteger sum;
//        long count;
//        public Node(int s, int e, BigInteger sum, long count){
//            this.s =s;
//            this.e =e;
//            this.sum = sum;
//            this.count = count;
//        }
//    }
//    // public static void dfs(int p1, int p2, long sum, long count){
//    //     System.out.print(p1+","+p2+" ");
//    //     if( sum == target){
//    //         min = min>count? count:min;
//    //         return;
//    //     }
//    //     if (p1==0 && p2==endPoint-1)
//    //         return;
//    //     if(p1==p2) return;
//
//    //     if(p1+1<=2*endPoint-1){
//
//    //         dfs(p1+1, p2, sum -nlist.get(p1) , count++);
//    //     }
//    //     else {
//    //         if(p1+1==endPoint)
//    //             dfs(0, p2, sum -nlist.get(p1) , count++);
//    //     }
//
//    //     if(p2+1<=2*endPoint-1){
//    //         dfs(p1, p2+1, sum+nlist.get(p2), count++);
//    //     }
//    //     else{
//
//    //         if(p2+1==endPoint)
//    //             dfs(p1, 0, sum+nlist.get(p2), count++);
//    //     }
//
//    //     return;
//    // }
//
//
//}
