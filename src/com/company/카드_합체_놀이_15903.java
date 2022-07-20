package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드_합체_놀이_15903 {
    public static void main(String[] args)throws IOException {
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        long[] arr = new long[n];
        t = br.readLine().split(" ");
        for( int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(t[i]);
        }
        for( int i = 0; i<m; i++ ){
            Arrays.sort(arr);
            long s = arr[0]+arr[1];
//            s
            arr[0] = s;
            arr[1] = s;
        }
        long sum = 0;
        for( long i: arr) sum+=i;
        System.out.println(sum);
    }
}
