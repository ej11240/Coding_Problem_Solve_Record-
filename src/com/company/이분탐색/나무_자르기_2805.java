package com.company.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나무_자르기_2805 {
    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        t = bufferedReader.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i<n; i++){
            list.add(Integer.parseInt(t[i]));
//            System.out.println(t[i]);
        }
        Collections.sort(list);
        int l = 1;
        int h = list.get(list.size()-1);
        int mid = (l+h)/2;
        while (l<h){
            mid = (l+h)/2;
            long count = 0;
            for (int i = 0; i<n; i++){
                if( list.get(i)>mid ){
                    count+=list.get(i)-mid;
//                    System.out.println(list.get(i)+" "+count);
                }

            }
//            System.out.println(l+" "+mid+" "+h+", "+count +"vs"+m);
//            if(count== m) break;
            if(count<m){
                h = mid;
            }
            else
                l = mid+1;
        }
        System.out.println(l-1);
    }
}
