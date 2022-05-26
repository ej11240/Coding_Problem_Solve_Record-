package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 행렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t =br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            t =br.readLine().split("");

            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(t[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            t =br.readLine().split("");

            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(t[j]);
            }
        }

        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    count++;
                    for (int p = i; p < i + 3; p++) { //3x3에 대해
                        for (int q = j; q < j + 3; q++) { // 0->1 / 1->0 변환
                            a[p][q] = (a[p][q] == 0) ? 1 : 0;
                        }
                    }
                }
            }
        }

        boolean same = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    same = false;
                    break;
                }
            }
        }

        if(same) System.out.println(count);
        else System.out.println(-1);
    }
}
