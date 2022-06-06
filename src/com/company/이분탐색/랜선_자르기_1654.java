package com.company.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 랜선_자르기_1654 {
    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Collections.sort(list);

        long l = 1;
        long h = list.get(list.size()-1);
        long mid = 1;
        while (l<=h){
            mid = (l+h)/2;
            long count = 0;
            for (int i = 0; i< list.size(); i++){
                count+=list.get(i)/mid;
            }
            if(count<m) {
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        System.out.println(h+" ");
    }
}
