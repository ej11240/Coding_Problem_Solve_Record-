package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int H = Integer.parseInt(t[1]);
        int[] rock = new int[N];
        int[] trock = new int[H+1];
        int[] brock = new int[H+1];
        int answer =200001;

        for(int i = 0; i<N; i++) {
            if(i%2==0){
                brock[Integer.parseInt(bufferedReader.readLine())]++;
            }else {
                trock[Integer.parseInt(bufferedReader.readLine())]++;
            }
        }

        // 석순 중순 다 누적합 구하기
        int[] tsum =new int[H+1];
        int[] bsum =new int[H+1];
        for (int i = 1; i < H + 1; i++) {
            tsum[i] = tsum[i - 1] + trock[i];
            bsum[i] = bsum[i - 1] + brock[i];
//            System.out.println(tsum[i]+", b:"+bsum[i]);
        }

        int same =1;

        for(int i = 1; i<=H; i++){ //i는 높이
            int count = 0;
            count = count + bsum[H] - bsum[i - 1];
            count = count + tsum[H] - tsum[H - i];

            if(answer>count) {
                answer=count; same=1;
//                System.out.println("a: "+answer);
            }
            if (answer==count) {
                same++;
//                System.out.println("c: "+count);
            }

        }

        System.out.println(answer+" "+(same));
    }
}
