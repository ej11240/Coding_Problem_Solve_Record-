package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2529 {
    static int k;
    static boolean[] visit = new boolean[10];
    static char[] signs;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        signs = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }
        back("", 0);

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void back(String num, int depth) {
        if (depth == k + 1) {
            list.add(num);
            return;
        }
//
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || (!visit[i] && compare(num.charAt(num.length() - 1) - '0', i, signs[depth - 1]))) {
                visit[i] = true;
                //
                back(num + i, depth+1 );
                visit[i] = false;
            }
        }
    }


    static boolean compare(int a, int b, int c) {
        if (c == '<') return a < b;
        else return a > b;
    }
}