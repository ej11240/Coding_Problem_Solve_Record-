package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int val = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);

            if(x=='(' || x=='['){
                stack.push(x);
                val*= (x=='(')?2:3;
            }else if(x==')'){
                if(stack.isEmpty() || stack.peek()!='(') {
                    result =0;
                    break;
                }
                if(i-1>0 && str.charAt(i-1)=='(') result+=val;
                stack.pop();
                val/=2;
            }else{
                if(stack.isEmpty() || stack.peek()!='[') {
                    result =0;
                    break;
                }
                if(i-1>0 && str.charAt(i-1)=='[') result+=val;
                stack.pop();
                val/=3;
            }
        }
        if(!stack.isEmpty()) result = 0;
        System.out.println(result);
    }
}
