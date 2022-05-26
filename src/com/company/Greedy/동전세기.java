package com.company.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 동전세기 {
    class Coin implements Comparable<Coin>{
        int 단위;
        int 갯수;
        public Coin(int 단위, int 갯수){
            this.단위 = 단위;
            this.갯수 = 갯수;
        }
        @Override
        public int compareTo(Coin c){
            return c.단위 -this.단위 ;
        }

    }
    public void 동전세기Main(){
        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(new Coin(1000,2));
        coins.add(new Coin(500,2));
        coins.add(new Coin(100,1));
        coins.add(new Coin(10,2));

        int returnWon = 2270;
        ArrayList<Integer> answer = new ArrayList<>();

        Collections.sort(coins);

        for(Coin coin:coins){
            if(coin.갯수>returnWon / coin.단위){
                answer.add( returnWon / coin.단위);
                returnWon = returnWon - (returnWon/coin.단위)*coin.단위;
            }
            else {
                answer.add(coin.갯수);
                returnWon = returnWon - (coin.갯수)*coin.단위;
            }
            System.out.println(returnWon);
        }
        System.out.println(answer);
    }

    public void coinMain2(){
        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(new Coin(500,1000));
        coins.add(new Coin(100,1000));
        coins.add(new Coin(50,1000));
        coins.add(new Coin(10,1000));
        coins.add(new Coin(5,1000));
        coins.add(new Coin(1,1000));
        Collections.sort(coins);

        int returnWon = 1000 - 380;
        ArrayList<Integer> answer = new ArrayList<>();

        for(Coin coin:coins){
            if(coin.갯수>returnWon / coin.단위){
                answer.add( returnWon / coin.단위);
                returnWon = returnWon - (returnWon/coin.단위)*coin.단위;
            }
            else {
                answer.add(coin.갯수);
                returnWon = returnWon - (coin.갯수)*coin.단위;
            }
            System.out.println(returnWon);
        }
        System.out.println(answer);
    }
    public void coinMain3(){
        ArrayList<Coin> coins = new ArrayList<>();
        Scanner s =new Scanner(System.in);
        int N =s.nextInt();
        int returnWon = s.nextInt();
        for(int i =0; i<N; i++){
            int t1 = s.nextInt();
            coins.add(new Coin(t1,10000));
        }

        Collections.sort(coins);

        ArrayList<Integer> answer = new ArrayList<>();

        for(Coin coin:coins){
            if(coin.갯수>returnWon / coin.단위){
                answer.add( returnWon / coin.단위);
                returnWon = returnWon - (returnWon/coin.단위)*coin.단위;
            }
            else {
                answer.add(coin.갯수);
                returnWon = returnWon - (coin.갯수)*coin.단위;
            }
            System.out.println(returnWon);
        }
        System.out.println(answer);
    }
}
