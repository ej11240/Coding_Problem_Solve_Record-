package com.company;

public class DfsStudy {

    public void runs(){
        int[] numbers = { 1,2,3,4,5};
        boolean[] visit = {false,};
        dfs(numbers, 0, visit);
    }
    void dfs(int[] numbers, int index, boolean[] visit){
        visit[index] = true;

        for (int i:numbers){
            if(!visit[i])
                dfs(numbers,i, visit);
        }
    }
}
