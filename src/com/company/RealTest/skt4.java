package com.company.RealTest;

public class skt4 {
//    static List<Integer> result = new LinkedList<>();
//    public static void main(String[] args) {
//        String[] rsp3 = { "SPR","PPR","PSS","RSS","RRR"};
//        System.out.println(solution(rsp3));
//
//    }
//    public static int[] solution(String[] rsp3) {
//        int[] answer = {};
//
//        System.out.println(rsp3[1].substring(0,1));
//
//        for( int j =0; j<rsp3.length; j++) {
//            int p1 = 0;
//            int p2 = 0;
//            int p3 = 0;
//            int[] p ={0,0,0};
//            for (int i = 0; i < 3; i++) {
//                if (rsp3[j].substring(i,i+1)=="S"){
//                    p[i]=1;
//                }else if(rsp3[j].substring(i,i+1)=="R"){
//                    p[i]=2;
//                }else if(rsp3[j].substring(i,i+1)=="P"){
//                    p[i]=3;
//                }
//            }
//            display(p[0],p[1],p[2]);
//        }
//        return answer;
//    }
//    static int[] v = {0,0,0};
//
//
//    public static void display (int 철수, int 영희, int 플레이어) {
//        if ((플레이어 + 철수 + 영희)%3 == 0) {
//            return;
//        }
//        if (철수 == 영희) {
//            if (플레이어 == 1) {
//                if (철수 == 2) {v[0]+=2;}
//                if (철수 == 3) { if(v[1]>v[2]) v[1]+=2; if(v[2]>v[1]) v[2]+=2; if(v[1]==v[2]) {v[2]+=1; v[1]+=1;}}
//            }
//            if (플레이어 == 2) {
//                if (철수 == 3) defeat();
//                if (철수 == 1) victory();
//            }
//            if (플레이어 == 3) {
//                if (철수 == 1) defeat();
//                if (철수 == 2) victory();
//            }
//        }
//        if (철수 != 영희) {
//            if (플레이어 == 1) {
//                if (철수 == 1 && 영희 == 2) defeat();
//                if (철수 == 1 && 영희 == 3) victory();
//                if (철수 == 2 && 영희 == 1) defeat();
//                if (철수 == 3 && 영희 == 1) victory();
//            }
//            else if (플레이어 == 2) {
//                if (철수 == 1 && 영희 == 2) victory();
//                if (철수 == 2 && 영희 == 1) victory();
//                if (철수 == 2 && 영희 == 3) defeat();
//                if (철수 == 3 && 영희 == 2) defeat();
//            }
//            else if (플레이어 == 3) {
//                if (철수 == 1 && 영희 == 3) defeat();
//                if (철수 == 2 && 영희 == 3) victory();
//                if (철수 == 3 && 영희 == 1) defeat();
//                if (철수 == 3 && 영희 == 2) victory();
//            }
//        }
//    }
}
