package com.company.Greedy;

import java.util.Scanner;

public class p16953 {
    static int r,c;
    static String map[];
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static int ans=Integer.MIN_VALUE;
    //알파벳을 0~25의 숫자로 바꿔서 visit체크
    static boolean[] vis=new boolean[26];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        map=new String[r];
        for (int i = 0; i < r; i++) {
            map[i]=sc.next();
        }
        vis[(int)map[0].charAt(0)-65]=true;//시작점의 문자 체크
        go(0,0,1);
        System.out.println(ans);
    }
    private static void go(int y,int x,int cnt) {
        if(cnt>ans) { //돌때마다 cnt가 더 큰 부분이 있으면 갱신
            ans=cnt;
        }

        for (int k = 0; k < 4; k++) {
            int yy=y+dy[k];
            int xx=x+dx[k];
            if(xx<0 || yy<0 || xx>=c ||yy>=r)continue;
            int c=(int)map[yy].charAt(xx)-65;
            if(vis[c])continue;
            vis[c]=true; //넣고
            go(yy,xx,cnt+1);
            vis[c]=false; //다시 빼준다.
        }

    }
}
