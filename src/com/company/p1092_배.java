package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class p1092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int ans =0;
        int c = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> crain = new LinkedList<>();
        String[] t = bufferedReader.readLine().split(" ");
        for (int i = 0; i<c; i++){
            crain.add( Integer.parseInt(t[i]));
        }

        int b = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> box = new LinkedList<>();
        t = bufferedReader.readLine().split(" ");
        for (int i = 0; i<b; i++){
            box.add( Integer.parseInt(t[i]));
        }
        Collections.sort(crain, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
//        for (int i =0; i<b; i++){
//            System.out.println(box.get(i));
//        }

        if(box.get(0)>crain.get(0)){
            System.out.println(-1);
            return;
        }
        while (true){
            if(box.size()==0) break;
            for (int i =0; i<crain.size(); i++){
                for (int j =0; j<box.size(); j++){
                    if(crain.get(i)>=box.get(j)){
                        box.remove(j);
                        break;
                    }
                }
            }
            ans++;
        }

        System.out.println(ans);
    }
}
