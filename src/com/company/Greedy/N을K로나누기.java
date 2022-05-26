package com.company.Greedy;

public class N을K로나누기 {
    public static void main(String[] args) {
        int n=25;
        int k=5;

        int count =0;
        while (n!=1){
            if(n%k==0){
                n=n/k;
            }else {
                n=n-1;
            }
            System.out.println(n);
            count++;
        }
        System.out.println(count);
    }
}
