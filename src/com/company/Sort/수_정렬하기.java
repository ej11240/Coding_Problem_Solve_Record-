package com.company.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수_정렬하기 {
    static int N, L, R, ans;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N =  Integer.parseInt(st.nextToken());

        array = new int[N+1];

        for(int i = 0; i<N; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }

        for(int i = N-1; i > 1; i--){
            int biggest =-1;
            int place = -1;
            for(int j = 0; j<=i; j++){
                if(biggest <array[j]){
                    place = j;
                    biggest =array[j];
                }
            }
            int tmp = array[place];
            array[place] = array[i];
            array[i] = tmp;
        }

        for(int i = 0; i<N; i++){
            System.out.println(array[i]);
        }

    }
}
