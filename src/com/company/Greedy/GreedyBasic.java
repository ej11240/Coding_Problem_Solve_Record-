package com.company.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyBasic {

    class Action implements Comparable<Action>{
        String name;
        int startTime;
        int endTime;

        public Action(String name, int startTime, int endTime){
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }
        @Override
        public int compareTo(Action a){
            return this.endTime - a.endTime;
        }
        @Override
        public String toString(){
            return this.name;
        }

    }

    public void greedyMain(){
        ArrayList<Action> list = new ArrayList<>();
        list.add(new Action("a",7,8));
        list.add(new Action("b",5,7));
        list.add(new Action("c",3,6));
        list.add(new Action("d",1,2));
        list.add(new Action("e",6,9));
        list.add(new Action("f", 10,11));
        Collections.sort(list);
        String answer = "";
        int pastendtime = -1;

        for (Action a:list) {
//            System.out.println(a.name);
            if(a.startTime>pastendtime){
                answer=answer+a.name;
                pastendtime=a.endTime;
//                System.out.println(pastendtime);
            }
        }
        System.out.println(answer);


    }
}
