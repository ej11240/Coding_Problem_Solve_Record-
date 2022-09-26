package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class p1654_랜선자르기 {
    public static int k;
    public static int[] list;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        k = Integer.parseInt(t[0]);
        n = Integer.parseInt(t[1]);
        list = new int[k];
        int max_len = 0;
        for (int i =0; i<k; i++){
            list[i] = Integer.parseInt(bufferedReader.readLine());
            max_len = max_len<list[i] ? list[i] : max_len;
        }

        binery_search(1,max_len,0);

    }

    public static void binery_search(int start, int end, int pre_mid){
        System.out.println(start+" "+end);
        if(start>=end) {
            System.out.println(end);
            return;
        }

        int mid = (start+end)/2;
        int count = 0;
        for (int i =0; i<k; i++){
            count += list[i]/mid > 0 ? list[i]/mid : 0;
        }
        System.out.println(count);
        if(count>=n){
            binery_search(mid+1, end, mid);
        }
        else {
            binery_search(start, mid-1, mid);
        }
    }
}
