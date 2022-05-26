package com.company.RealTest;

import java.util.LinkedList;
import java.util.List;

public class skt2 {
    static List<Integer> result = new LinkedList<>();
    public static void main(String[] args) {
        int[] deposit = { 500, 1000, -300, 200, -400, 100, -100};
        System.out.println(solution(deposit));

    }
    public static int[] solution(int[] deposit) {
        int[] answer = {};

        result.add(0,deposit[0]);

        for(int i=1; i<deposit.length; i++) {
            int  depo = deposit[i];
            algo(depo, i);
        }
        answer = new int[result.size()];
        for( int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    public static void algo(int depo , int i){

            if(depo >0){
                result.add( depo  ) ;
//                System.out.println("here:"+result.get(result.size()-1));
                return;
            } else {
                for( int j =result.size()-1;j>=0; j-- ){
                    if(result.get(j)>-depo){
                        result.set( j,  result.get(j)+depo);
//                        System.out.println("here1:"+result.get(result.size()-1)+", "+ depo);
                        return;
                    }else if(result.get(j)==-depo){
                        result.remove(j);
//                        System.out.println("here2:"+result.get(result.size()-1));
                        return;
                    }else if(result.get(j)<-depo){
                        int left = -(-(depo) -result.get(j));
                        result.remove(j);
//                        System.out.println("here3:"+result.get(result.size()-1)+", "+left);
                        algo(left, i);
                        return;
                    }
                }
            }

    }
}
