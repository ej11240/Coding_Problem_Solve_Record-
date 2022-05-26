package com.company.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박스채우기 {
    public static int[] box = new int[21];
    public static boolean f =true;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s =bufferedReader.readLine().split(" ");
        int L = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);
        int H = Integer.parseInt(s[2]);
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i<n; i++){
            s =bufferedReader.readLine().split(" ");
            box[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
        }

//        filling(L,W,H);
        if(f) System.out.println(filling(L,W,H));
    }

    public static int filling(int l, int w, int h){
        int t =1;
        if(w<t) t=w;
        if(h<t) t=h;
        if(l<=0||w<=0||h<=0) return 0;

        double s = Math.log10(t) / Math.log10(2);

        do {
            if(box[(int) s]!=0) continue;
            box[(int)s]--;
            int T = (int) Math.pow(2,(int)s);
            return filling(1-T,T,h) +filling(1,w-T,h)+filling(T,T,h-T)+1;

        }while (--t>=0);
        f = false;
        return -1;
    }
}
