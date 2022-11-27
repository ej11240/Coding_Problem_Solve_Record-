package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class p5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tt = Integer.parseInt(bufferedReader.readLine());
//        String answer="";
        StringBuffer sb = new StringBuffer();
        for (int c=0; c<tt; c++){
            boolean dir = true;
            boolean error = false;
            //일반배열 말고 dequeue를 사용해야한다.
            Deque<Integer> deque = new LinkedList<>();
            String[] p= bufferedReader.readLine().split("");
            int len = Integer.parseInt(bufferedReader.readLine());
            String tmp = bufferedReader.readLine();
            tmp = tmp.substring(1, tmp.length() - 1);
            String arr[] = tmp.split(",");

            if (!tmp.equals("")) {
                for (int j = 0; j < arr.length; j++) {
                    deque.add(Integer.parseInt(arr[j]));
                }
            }

            for (int j = 0; j < p.length; j++) {
//                System.out.println(p[j]);
                switch (p[j]) {
                    case "R":
                        dir = !dir;
                        break;

                    case "D":
                        if (!deque.isEmpty()) {
                            if (dir) { // 순방향
                                deque.pollFirst();
                            } else { // 역방향
                                deque.pollLast();
                            }
                            break;
                        } else {
                            error = true;
                            break;
                        }
                    default:
                        break;
                }

                if (error)
                    break;
            }
            if(!error){
                sb.append("[");
                if (dir) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (deque.isEmpty()) break;
                        sb.append(",");
                    }

                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (deque.isEmpty())
                            break;
                        sb.append(",");
                    }
                }
                sb.append("]\n");

            }
            else {
                sb.append("error\n");
            }
        }
        System.out.println(sb);
    }
}
