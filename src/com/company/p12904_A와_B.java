package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p12904_A와_B {
    public static String s;
    public static String t;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        s = bufferedReader.readLine();
        t = bufferedReader.readLine();

        while (s.length()!=t.length()){
            if(t.charAt(t.length()-1)=='A')
                t = t.substring(0,t.length()-1);
            else if(t.charAt(t.length()-1)=='B') {
                t = t.substring(0, t.length() - 1);
                StringBuilder sb = new StringBuilder(t);
                t = sb.reverse().toString();
            }
        }
        if(s.equals(t))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
