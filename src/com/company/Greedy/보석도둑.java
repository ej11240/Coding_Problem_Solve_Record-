package com.company.Greedy;

import java.io.*;
import java.util.*;

public class 보석도둑 {
    public static void main(String[] args ) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(reader.readLine());

            int m= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());

            list.add(new Jewel(m,v));

        }
        Collections.sort(list);

//        int[] c =new int[k];
        ArrayList<Bag> bags=new ArrayList<>();

        for( int i =0; i<k; i++){
            st = new StringTokenizer(reader.readLine());
            int cc= Integer.parseInt(st.nextToken());
            bags.add(new Bag(cc));
        }

        Collections.sort(bags);

//        for(Jewel act : list){
//            System.out.print(act.m + ", ");
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        long priceSum = 0L;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && list.get(idx).m <= bags.get(i).c) {
                pq.add(list.get(idx).v);
//                System.out.println(list.get(idx).m+" 그리고 가방 크기는 "+bags.get(i).c);
                idx++;
            }
            if (!pq.isEmpty()) priceSum += pq.poll();
        }

        System.out.println(priceSum);

    }


}
class Jewel implements Comparable<Jewel>{

    int m;
    int v;
    public Jewel( int m, int v){
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel a) {
        return  this.m-a.m;
    }
}
class Bag implements Comparable<Bag>{
    PriorityQueue<Jewel> jewels;
    int c;
    public Bag(int c){
        this.c=c;
    }
    @Override
    public int compareTo(Bag a) {
        return  this.c-a.c;
    }
}
