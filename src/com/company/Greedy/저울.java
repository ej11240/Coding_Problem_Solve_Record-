package com.company.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 저울 {

    public static List<Integer> gram;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        gram = new LinkedList();

        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            gram.add(Integer.parseInt(s[i]));
        }

        Collections.sort(gram);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(sum+1 < gram.get(i)){
                break;
            }
            sum +=gram.get(i);
        }
        System.out.println(sum+1);

    }
}