package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1083_소트 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[51];
        String[] t = br.readLine().split(" ");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(t[i]);

        int s = Integer.parseInt(br.readLine());
        int i=0;
        while (i<n-1 && s>0 ){
            int count =0;
            int num_max = arr[i];
            int idx_max = i;
            int j=i+1;
            while (j<n && count<s){
                if(num_max<arr[j]){
                    num_max = arr[j];
                    idx_max = j;
                }
                j++;
                count++;
            }
            j = idx_max;
            if(idx_max>i){
                while (j!=i){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    j--;
                }
            }
            s -= idx_max-i;

            i++;
        }
        for ( i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
