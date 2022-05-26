package com.company.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p1715_cardsort {
    class Card implements Comparable<Card>{

        int cardcount;

        public Card (int cardcount){
            this.cardcount = cardcount;
        }
        @Override
        public int compareTo(Card c){
            return this.cardcount - c.cardcount;
        }
    }

    public void p1715main(){
        Scanner sc=new Scanner(System.in);
        int N =sc.nextInt();
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i<N; i++){
            cards.add(new Card(sc.nextInt()));
        }
        Collections.sort(cards);

        int answer =0;

        while (cards.size()!=0){
            //리스트에서 맨 앞에 있는거 2개 가져오기
            int t1 = cards.get(0).cardcount;
            int t2 = cards.get(1).cardcount;
            System.out.println(t1+" ," +t2);
            // 그리고 remove(인덱스)
            cards.remove(0);
            cards.remove(0);
            //더하기 =>plus
            int plus = t1+t2;
            //더한 값을 리스트에 정렬 순서에 맞추어 적절한 위치에 넣기
            //리스트에 있는 값을 앞에서부터 하나씩 보고 plus값이 더 작은 경우 그 인덱스 값을 가져와서 add(인덱스 값, plus)를 해준다
            System.out.println("1  "+cards.size());

            answer= answer+plus;
            for(int i =0; i<cards.size(); i++){
                if(cards.get(cards.size()-1).cardcount<plus){
                    cards.add(new Card(plus));
                    System.out.println("3  "+cards.get(cards.size()-1).cardcount+", "+plus+", "+(cards.get(cards.size()-1).cardcount<plus)+", "+cards.size());
                    break;
                }
//                if(cards.get(0).cardcount>)
                if(cards.get(i).cardcount>=plus){
                    cards.add(i,new Card(plus));
                    System.out.println("2  "+cards.size()+","+i);
                    break;
                }
            }

        }
        System.out.println(answer);
    }

}
