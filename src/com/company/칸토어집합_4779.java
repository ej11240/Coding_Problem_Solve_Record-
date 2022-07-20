package com.company;

import java.io.*;

public class 칸토어집합_4779 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String t;
        while((t = br.readLine()) != ""){
            if(t.equals("")) break;
            int n = Integer.parseInt(t);

            String s = makestring(n, true);
            bw.write(s);
            bw.write("\n");
            bw.flush();
        }

        return;
    }


    public static String makestring (int n, boolean mid){
        if(mid == false){
            String result ="";
            for(int i = 0; i < (int) Math.pow(3, n); i++){
                result+=" ";
            }
            return result;
        }
        else{
            if(n == 0) return "-";
            return makestring(n-1, true) + makestring(n-1, false) + makestring(n-1, true);
        }
    }
}
