package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BfsStudy {
    public void runs(){
        int[] numbers = { 1,2,3,4,5};
        boolean[] visit = {false,};
        bfs(numbers, 0, visit);
    }
    void bfs(int[] numbers, int start, boolean[] visit){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        //큐에 이웃하는 정점을 담아놓고 차례대로 pop()하여 구현
        // 탐색해야하는 노드가 많지 않다면 좋지 않음
        //저장공간이 많이 필요함

        visit[start] = true;

        while (!queue.isEmpty()){
            int next = queue.poll();//poll은 가장 먼저 보관한 값을 꺼내고 반환

            for (int i: numbers){
                if(!visit[i]){
                    queue.add(i);

                }
            }

        }
    }
}
