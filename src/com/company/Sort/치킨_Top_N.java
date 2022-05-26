package com.company.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치킨_Top_N {
    public static void main(String[] args ) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] list = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i =0; i<n; i++ ){
            list[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        int k =Integer.parseInt(st.nextToken());

        int startp =n/2;

        while (startp>=k){
            int d= n/startp;
            for (int i =0; i<n; i+=d) Arrays.sort(list,i,i+d);

            startp/=2;
        }
        for(int j =0; j<n;j++ ) System.out.print(list[j]+" "); //System.out.println("");

    }

//    merge(s,e):
//            if s==e:
//            return
//    mid=int((s+e)/2)
//    merge(s,mid)
//    merge(mid+1,e)
//    check(s,e);
    public static void Merge(int s,int e){
        if(s==e) return;

    }


}
