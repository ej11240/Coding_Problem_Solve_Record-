package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 종이_접기_1802 {
    public static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] arg)throws IOException {
        int count ;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bufferedReader.readLine());

        for( int i =0; i<count; i++){
            String[] t = bufferedReader.readLine().split("");
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j< t.length; j++)
                l.add(Integer.parseInt(t[j]));
            list.add(l);
            solve(i);
        }


//        int mid = t.length/2;
//        boolean possible = true;
//        for(int j = 0; j< t.length; j++){
//            int c = Integer.parseInt(t[j]);
//            l.add(c);
//            if( j> mid ){
//                if( c == l.get(2*mid-j) ){
//                    possible=false;
//                }
//            }
//        }
//        boolean possible = true;
//        if( possible) System.out.println("YES");
//        else System.out.println("NO");

    }
    public static void solve(int c ){
//        int mid, ll, rr;
//        if( l>r) return;
//        mid = (l+r)/2;
//        for(ll=mid-1, rr=mid+1; ll>=l&&rr<=r; ll--,rr++;){
//
//        }
        List<Integer> l = list.get(c);
        int length = l.size();
        int mid=length/2;
        boolean possible = true;
        while (mid!=0){
            for(int i =length-1, j=0; i>mid; i--,j++ ){
                if(l.get(i)==l.get(j)){
                    possible=false;
                    break;
                }
            }
            if(!possible)break;
            length/=2;
            mid/=2;
        }
        if(possible) System.out.println("YES");
        else System.out.println("NO");
    }
}
