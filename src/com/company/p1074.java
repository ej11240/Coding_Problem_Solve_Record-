package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class p1074 {
    static int n;
    static int[] num;
    static ArrayList<Integer> arr=new ArrayList<>();

    public static void p1074() throws IOException {

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        num=new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i]=sc.nextInt();
        }

        arr.add(0);
        for (int i = 1; i <= n; i++) {
            if(num[i]>arr.get(arr.size()-1)) {// 더 큰수는 뒤에 붙는다.
                arr.add(num[i]);
            }else {// 작거나 같은 수는 앞에 붙음 더 작거나 같은 위치를 binary로 찾는다.
                int idx=binary(num[i]);
                arr.set(idx, num[i]);//들어갈 수 있는 위치를 갱신해준다.
            }
        }
        System.out.println(arr.size()-1);

    }

    private static int binary(int num) {//a 새로운 수 ,b 기존 수
        int left=0;
        int right=arr.size()-1;
        while(left<right) {
            int mid=(left+right)/2;
            if(arr.get(mid)>=num) {//num이 들어갈 자리. 들어갈 수 있는 자리를 찾으면
                // 더 작은 곳도 혹시 되나? 하고 확인해준다.
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}
