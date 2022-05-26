package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DSLR_9019 {
    public static List<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in));
        int test = Integer.parseInt(bufferedReader.readLine());
        answer = new LinkedList<>();
        while (test>0){
            String[] t = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            String cur ="";
            cur = bfs(a,b, cur);

//            System.out.println(cur);
            answer.add(cur);
            test--;
        }
        for (String s : answer)
            System.out.println(s);
    }

    public static String bfs(int a, int b, String cur){

        boolean[] visited = new boolean[10000];
        Queue<Input> queue = new LinkedList<>();
        queue.add(new Input(a,""));
        while (!queue.isEmpty()){
            Input t = queue.poll();
            if(t.n==b) {
                if(cur.length()==0) cur = t.cur;
                else cur = cur.length()>t.cur.length() ? t.cur : cur;
//                System.out.println(cur + "+=================================");
                return cur;
            }
//            System.out.println(t.n+", "+t.cur);
            int d = D(t.n);
            int s = S(t.n);
            int l = L(t.n);
            int r = R(t.n);
            if(!visited[d]) {
                queue.add(new Input(d, t.cur+"D")); visited[d]= true;
            }
            if(!visited[s]) {
                queue.add(new Input(s, t.cur+"S")); visited[s]= true;
            }
            if(!visited[l]) {
                queue.add(new Input(l, t.cur+"L")); visited[l]= true;
            }
            if(!visited[r]) {
                queue.add(new Input(r, t.cur+"R")); visited[r]= true;
            }

        }

        return cur;
    }
    public static class Input {
        int n;
        String cur;
        public Input(int n, String cur){
            this.n = n;
            this.cur = cur;
        }
    }
    public static int D(int a){
        a=a*2;
        return a%10000;
    }
    public static int S(int a){
        if(a==0) a=9999;
        else a=a-1;
        return a;
    }
    public static int L(int a){
        String result = String.valueOf(a);

        switch (result.length()){
            case 1:
                result = "00"+ result +"0";
                break;
            case 2:
                result = "0"+result+"0";
                break;
            case 3:
                result = result+"0";
                break;
            default:
                result = result.substring(1) +result.substring(0,1);
        }

        return Integer.parseInt(result);
    }
    public static int R(int a){
        String result = String.valueOf(a);

        switch (result.length()){
            case 1:
                result =  result +"000";
                break;
            case 2:
                result = result.substring(1)+"00"+result.substring(0,1);
                break;
            case 3:
                result = result.substring(2)+"0"+result.substring(0,2);
                break;
            default:
                result = result.substring(3) +result.substring(0,3);
        }

        return Integer.parseInt(result);
    }
}
