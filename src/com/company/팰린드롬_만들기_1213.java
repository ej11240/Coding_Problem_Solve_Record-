package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 팰린드롬_만들기_1213 {
    // 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말, 숫자, 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<t.length; i++){
            if(map.containsKey(t[i])){
                int old = map.get(t[i]);
                map.put(t[i],old+1);
            }
            else {
                map.put(t[i], 1);
            }
        }
        int even =0;
        final String[] oddchar = {""};
        final int[] count = {0,0}; //홀,짝 갯수
        map.forEach((k,v)->{
            if(v%2 == 1) {
                count[0]++;
                oddchar[0] =k;
            }
            else {
                count[1]++;
                map.put(k, v/2);
            }
        });

        if(count[0]>1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        Object[] mapkey = map.keySet().toArray();
        Arrays.sort(mapkey);

        if(count[0]==1){

            int minus = map.get(oddchar[0]) -1;
            map.put(oddchar[0],minus/2);

            final String[] answer = {""};
            map.forEach((k,v)->{
                for (int i = 0; i<v; i++) {
                    answer[0] += k;
                }
            });
            System.out.print(answer[0]+oddchar[0]);
            for (int i = answer[0].length()-1; i>=0; i--){
                System.out.print(answer[0].charAt(i));
            }
        }
        if(count[0]==0){
            final String[] answer = {""};
            map.forEach((k,v)->{
                for (int i = 0; i<v; i++) {
                    answer[0] += k;
                }
            });
            System.out.print(answer[0]);
            for (int i = answer[0].length()-1; i>=0; i--){
                System.out.print(answer[0].charAt(i));
            }
        }

    }
}
