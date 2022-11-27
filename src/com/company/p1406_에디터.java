package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class p1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int m = Integer.parseInt(bufferedReader.readLine());

//        LinkedList<Character> list = new LinkedList<Character>();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            leftStack.push(s.charAt(i));
        }

        for(int i = 0; i < m; i++){
            String cmd = bufferedReader.readLine();
            switch (cmd.charAt(0)){
                case 'L':
                    if(leftStack.empty()) break;
                    rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(rightStack.empty()) break;
                    leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if(leftStack.empty()) break;
                    leftStack.pop();
                    break;
                case 'P':
                    leftStack.push(cmd.charAt(2));
                    break;
            }
        }
        while(!leftStack.empty()){
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!rightStack.empty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }

}
