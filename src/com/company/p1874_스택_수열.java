package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p1874_스택_수열 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder answer = new StringBuilder("");
        int cur = 0;
        int point =0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            cur = Integer.parseInt(bufferedReader.readLine());
//            while (point<=cur){
                if(cur>point){
                    for (int j = point+1; j<=cur; j++){
                        stack.push(j);
                        answer.append("+");
                        answer.append('\n');
                    }
                    point = cur;
                }

                else if(stack.peek() != cur){
                    System.out.println("NO");
                    return;
                }

                stack.pop();
                answer.append("-");
                answer.append('\n');
//            }
        }

        System.out.println(answer);

    }
}
