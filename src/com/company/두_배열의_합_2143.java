package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두_배열의_합_2143 {
    public static int[] a;
    public static int[] b;
    public static void main(String[] args) throws IOException {
        int t,n, m;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bufferedReader.readLine());

        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];
        String[] s = bufferedReader.readLine().split(" ");
        for(int i =0; i < n; i++){
            a[i] = Integer.parseInt(s[i]);
        }

        m = Integer.parseInt(bufferedReader.readLine());
        b = new int[m];
        s = bufferedReader.readLine().split(" ");
        for(int i =0; i < m; i++){
            b[i] = Integer.parseInt(s[i]);
        }

        List<Integer> suma = new ArrayList<>();
        for( int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                suma.add( sum);
            }
        }
        List<Integer> sumb = new ArrayList<>();
        for( int i = 0; i < m; i++){
            int sum = 0;
            for (int j = i; j < m; j++){
                sum+=b[j];
                sumb.add( sum);
            }
        }

        Collections.sort(suma);
        Collections.sort(sumb);

//        suma.forEach(a->System.out.print(a+" "));
//        System.out.println("");
//        sumb.forEach(a->System.out.print(a+" "));
//        System.out.println("");

        long count =0;
        int pa = 0;
        int pb = sumb.size()-1;
        while (pa<suma.size() && pb>=0){
//            if(pa>=suma.size() || pb<0)
//                break;
            long sum = suma.get(pa) + sumb.get(pb);
//            System.out.print(sum+" "+pa+" "+pb+" || ");
            if(sum==t){
                long ca =0;
                int avalue = suma.get(pa);
                int bvalue = sumb.get(pb);
                long cb =0;
//                System.out.println(avalue);
                while ( pa<suma.size() && suma.get(pa)==avalue ){
                    ca++;
                    pa++;
                }
                while ( pb>=0 && sumb.get(pb)==bvalue ){
                    cb++;
                    pb--;
                }
                count+= ca*cb;
            }
            else if(sum<t)
                pa++;
            else if(sum>t)
                pb--;
        }
        System.out.println(count);
    }
}
