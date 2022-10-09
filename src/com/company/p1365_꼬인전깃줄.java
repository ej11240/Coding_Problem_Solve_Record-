package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1365_꼬인전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] t = bufferedReader.readLine().split(" ");
        int[] arr = new int[n];
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<n; i++)
            list.add(Integer.parseInt(t[i]));

        ArrayList<Integer> result = new ArrayList<>();
        result.add(list.get(0));

        for(int i=1;i<n;i++){
            int next = list.get(i);
            if(result.get(result.size()-1)<next)
                result.add(next);
            else {
                int pos=-Collections.binarySearch(result,next)-1;
                result.set(pos,next);
            }
        }
        System.out.println(n-result.size());

    }
}
