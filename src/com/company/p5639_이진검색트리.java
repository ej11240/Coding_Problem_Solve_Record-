package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p5639_이진검색트리 {
    public static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList<>();

        while (true){
            String n = bufferedReader.readLine();
            if(n.equals("")  ) break;
            list.add(Integer.parseInt(n));
        }

        post(0, list.size()-1);

    }
    public static void post(int start, int end){
        if(start>end)
            return;
        int mid = end+1;
        for (int i = start+1; i<end+1; i++){
            if(list.get(start)<list.get(i)){
                mid = i;
                break;
            }
        }

        post(start+1, mid-1);
        post(mid, end);

        System.out.println(list.get(start));
    }
}
