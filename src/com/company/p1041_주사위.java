package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p1041_주사위 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        long minv = 51;
        String[] t = bufferedReader.readLine().split(" ");
        for (int i = 0; i<6; i++){
            list.add(Integer.parseInt(t[i]));
            minv = Math.min(list.get(i),minv);
        }

        long answer = 0;

        if(n==1){
            Collections.sort(list);
            for (int i = 0; i<5; i++)
                answer += list.get(i);
            System.out.println(answer);
            return;
        }

        long first = minv;
        answer +=  ((long)5*(long)n*(long)n-(long)16*(long)n+(long)12)*first ;

        long second =Long.MAX_VALUE;
        for (int i = 0; i<6; i++){
            for (int j = i+1; j<6; j++ ){
                if(j!=5-i){
                    second = Math.min( (long)list.get(i)+(long)list.get(j), second );
                }
            }
        }
        answer += ((long)8*(long)n-(long)12)* second;

        long t1 = Math.min((long)list.get(0),(long)list.get(5));
        long t2 = Math.min((long)list.get(1)+(long)list.get(2),
                Math.min((long)list.get(1)+(long)list.get(3),
                        Math.min((long)list.get(2)+(long)list.get(4),
                                (long)list.get(3)+(long)list.get(4)
                        )
                )
        );
        long third = t1+t2;
        answer += (long)4*third ;
        System.out.println(answer);


    }
}
