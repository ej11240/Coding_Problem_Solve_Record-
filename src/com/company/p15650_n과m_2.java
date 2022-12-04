package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15650_n과m_2 {
    public static int n;
    public static int m;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        arr = new int[10];

        back(1,0);
    }
    public static void back(int x, int length){
        if(length==m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=x;i<=n;i++){
            arr[length] = i;
            back(i+1,length+1);
        }

        return;
    }
}
