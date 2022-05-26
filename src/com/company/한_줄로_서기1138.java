package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한_줄로_서기1138 {
    public static int n;
    public static int[] list;
    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        list = new int[n+1];
        String[] t = bufferedReader.readLine().split(" ");
        for( int i =0; i<n; i++)
            list[i] = Integer.parseInt(t[i]);

        int[] answer = new int[n];
        for( int i =0; i<n; i++){
            int count = 0;
            while (list[i]!=0){
                if (answer[count]==0) list[i]--;
                count++;
            }
            while (answer[count]!=0)count++;
            answer[count]= i+1;
        }
        for (int i : answer) System.out.print(i);
    }
}
