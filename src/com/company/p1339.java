package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1339 {
    public static void p1339()throws IOException {
        int n; //단어 수
        char[] alpha =new char[10]; //알파벳 배열
        Integer[] weight=new Integer[10]; // 알파벳 가중치 합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n= Integer.parseInt(br.readLine());


        Arrays.fill(alpha,'.');
        Arrays.fill(weight,0);

        for(int i=0; i<n; i++){
            String str=br.readLine();
//            int w=10*str.length();
            int w=1;
            for(int t=str.length()-1; t>=0; t-- ){

                char ch = str.charAt(t);

                for(int v=0; v<10; v++){

                    if(alpha[v]==ch){
                        weight[v]+=w;
                        break;
                    }
                    else if(alpha[v]=='.'){
                        alpha[v]=ch;
                        weight[v]=w;
                        break;
                    }
                }
                w*=10;
            }
        }
        Arrays.sort(weight);
        int sum=0;
        for( int i=9;i>=0; i--) sum+=i*weight[i];
        System.out.println(sum);
    }
}
