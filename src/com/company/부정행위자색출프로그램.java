package com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class 부정행위자색출프로그램 {
    public static void main(String[] args){
        String[] logs = { "1901 1 100", "1901 2 99", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100" };
        try {
            solution(logs);
        } catch (IOException ioException) {

        }
    }
    public static void solution(String[] logs) throws IOException {

        Set<String> ans = new HashSet<>();
        HashMap<Integer,  HashMap<String,Integer> > list = new HashMap<Integer,  HashMap<String,Integer>>();
        HashMap<String, Set<Integer>> count = new HashMap<>();
        for (String i : logs){
            String[] t = i.split(" ");
            String p = t[0];
            int n = Integer.parseInt(t[1]);
            int s = Integer.parseInt(t[2]);
            HashMap<String,Integer> ps = new HashMap<>();
            ps.put(p,s);
            list.putIfAbsent(n,ps);
//            System.out.println(p+" "+n+" "+s);
            if (list.containsKey(n)) {
                list.get(n).put(p,s);
//                System.out.println(list.get(n));
            }
            Set<Integer> l = new HashSet<>();
            l.add(n);
            count.putIfAbsent(p,l);
            if(count.containsKey(p)) count.get(p).add(n);

        }
        Iterator it = count.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry item = (Map.Entry) it.next();
            String k = (String) item.getKey();
            Set<Integer> v = (Set<Integer>) item.getValue();
            if (v.size() < 5) it.remove();
            else {
                Set<String> reslut = getKeysByValue(count, v);
                System.out.println(k+" "+reslut);
                final boolean[] same = {true};
                reslut.forEach(p1-> { //k라는 사람과 값이 같은 사람들 배열
                    if(!p1.equals(k)) {
                        v.forEach(n -> {//각 문제들 에 대해
                            int s = list.get(n).get(k);
                            System.out.println(p1+" "+k+ " "+n + " !" + s+" "+ list.get(n).get(p1));
                            if (list.get(n).get(p1) != s) same[0] = false;
                        });

                        System.out.println("f"+same[0]);

                        if(same[0]) {ans.add(p1);ans.add(k);}
                    }

                });
            }
        }
//        try {
//            count.forEach((k, v) -> {
//                System.out.println(k + " " + v);
//                if (v.size() < 5) {count.remove(k);}
//                else {
//                    Set<String> reslut = getKeysByValue(count, v);
//                    System.out.println(reslut+".");
//                    final boolean[] same = {true};
//                    v.forEach(n -> {
//                        int s = list.get(n).get(k);
//                        System.out.println(n);
//                        reslut.forEach(p->{
//                            System.out.println(list.get(n)+" !"+s);
//                            if(list.get(n).get(p)!=s) same[0] =false;
//                        });
//                    });
//                    if(same[0]) ans.addAll(reslut);
//                }
//
//            });
//        }catch (Exception Exception){
//
//        }
        String[] answer = {};
//        Collections.sort(ans);
        answer = ans.toArray(new String[0]);

        Arrays.sort(answer);
//        answer.
        for(String s: answer)System.out.println(s);
    }
    public static <T, E> Set<T> getKeysByValue(HashMap<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
