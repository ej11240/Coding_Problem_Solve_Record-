package com.company.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_example {
    public void Queue_LinkedListExample(){
        Queue<String> q = new LinkedList<>();
        q.offer("강감찬"); //"강감찬"
        q.offer("홍길동"); //"강감찬","홍길동"
        System.out.println(q.peek());//"강감찬" 참조
        //여전히 "강감찬","홍길동"

        System.out.println(q.poll());//"강감찬" 꺼냄, 현재 "홍길동"
        q.offer("이순신"); //"홍길동", "이순신"
        q.offer("김구"); //"홍길동", "이순신", "김구"
        while(q.isEmpty()==false){
            System.out.println(q.poll());
            //"홍길동", "이순신", "김구" 순으로 꺼냄
        }

        /* 결과
        강감찬
        강감찬
        홍길동
        이순신
        김구
         */
    }

}
