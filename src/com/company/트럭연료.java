package com.company;

import java.util.*;

public class 트럭연료 {
    public static void main(String[] args){
//        int[] v = { 4,4,3 };
        int[] v = { 4,5,5 };
        int a = 2;
        int b = 1;
        solution(v,a,b);
    }
    public static void solution(int[] v, int a, int b){
        int answer = 0;
        List<Integer> vl = new LinkedList<>();
        for (int i: v) vl.add(i);
        int count = 0;
        Collections.sort(vl);
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = 0; int mm=Integer.MAX_VALUE;
        for(int i :v) { if(m<i) m=i;if(mm>i) mm=i;}

        for (int i : v) {
            if(map.containsKey(i)){
                map.put(i, map.get(i));
            }
            else map.put(i,1);
        }
         while (true) {


//            System.out.println(vl.get(0)+"!");
//            int min = vl.get(0);
//            if((min-(count)*b)<b) break;
//            if((vl.get(vl.size()-1)-(count)*b)<a) break;
//            int maxval = vl.get(vl.size()-1);
//            vl.remove(vl.size()-1);
//            Collections.sort(vl);
//            int index =Collections.binarySearch(vl, maxval-(a-b));
//            if(index<0) index = -index - 1;
//            vl.add(index, maxval-(a-b));
//            count++;




//            int current_max = -1;
//            int max_index =-1;
//            boolean nofuelexist =false;
//            for (int i = 0; i < v.length; i++) {
//                if (v[i] > current_max){
//                    current_max = v[i];
//                    max_index = i;
//                }
//                if (v[i] < b) nofuelexist=true;
//                v[i] = v[i]-b;
//            }
//            if( current_max<a || nofuelexist) break;
//            count++;
//            v[max_index] = v[max_index] - (a-b);
//            for (int i : v) System.out.print(i+" ");
//            System.out.println("");
//            System.out.println(v[max_index]+", "+ max_index+", "+ current_max+", "+ nofuelexist);
        }
//        System.out.println(count);
    }
//    public static int binsearch (int[] arr ,int left, int right){
//        int pl = left;
//        int pr = right;
//        int N = arr.length;
//
//        do {
//
//            int pc = (pl + pr) / 2;
//
//            long sum = 0;
//            for (int i = 0; i < N; i++) {
//                if (arr[i] > pc)
//                    sum += arr[i] - pc;
//            }
//
//            if (sum >= M)
//                pl = pc + 1;
//            else
//                pr = pc - 1;
//
//        } while (pl <= pr);
//
//        return pr;
//    }
}
