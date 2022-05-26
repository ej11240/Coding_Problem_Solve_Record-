package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16953 {
//    static int mini = 10000; // 임의의 큰수
//    static Long cnt;
    static Integer A;
    static Integer B;

//    public static void dfs(Long a, int cnt){
//        if (a > B) return;
//
//        if (a == B) {
//            mini = Math.min(mini, cnt);
//        }
//        dfs(a * 2, cnt + 1);
//        dfs(a * 10 + 1, cnt + 1);
//
//    }

    public static void main(String[] args )throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int temp = B;
        int cnt = 0;

        while (temp != 0) {
            if (temp == A) { // 시작 숫자 A가 되면 가능
                System.out.println(cnt + 1);
                return;
            }
            cnt++;
            if (temp % 2 == 0) { // 짝수이면 전의 수에서 X2를 한 상태
                temp = temp / 2;
            } else if (temp % 10 == 1) { // 끝의 자리가 1이면 전의 수에서 +1 을 한 상태
                temp = (temp - 1) / 10;
            } else { // 그 외의 경우는 나올 수 없으므로 불가능
                System.out.println(-1);
                return;
            }
        }
        System.out.println(-1);
//        dfs(A, 1);
//
//        if (mini == 10000) System.out.println("-1");
//        else System.out.println(mini);
    }
}
