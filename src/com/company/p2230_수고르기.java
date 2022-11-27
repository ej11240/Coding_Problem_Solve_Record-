package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class p2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        ArrayList<Integer> list = new ArrayList();
        for (int i=0; i<n; i++){
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Collections.sort(list);
//        System.out.println(list.get(list.size()-1));
        long sub=0; long answer =Long.MAX_VALUE;
        int l =0; int r=0;
        while (l<=r && r<n){
            if(sub >= m){
                answer  = Math.min(answer, sub);
                if(l==r){
                    r++;
                    if(r==n) break;
                }
                else l++;
            }
            else {
                r++;
                if(r==n)break;
            }

            sub = list.get(r) - list.get(l);
        }
        System.out.println(answer);
    }
}
