package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2841_외계인의기타연주 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        String s=bf.readLine();
        StringTokenizer st=new StringTokenizer(s);
        int n=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        Stack<Integer>[] stack=new Stack[7];
        for(int i=0; i<6; i++) {
            stack[i]=new Stack<Integer>();
            stack[i].push(0);
        }
        int cnt=0;
        while(n > 0) {

            String[] tt = bf.readLine().split(" ");

            int a=Integer.parseInt(tt[0]);
            int b=Integer.parseInt(tt[1]);

            while(stack[a].peek()>b) {
                stack[a].pop();
                cnt++;
            }
            if(stack[a].peek()<b) {
                stack[a].push(b);
                cnt++;
            }
            n--;
        }
        System.out.print(cnt);
    }
}