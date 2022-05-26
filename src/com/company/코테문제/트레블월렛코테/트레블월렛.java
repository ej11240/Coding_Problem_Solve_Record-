package com.company.코테문제.트레블월렛코테;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class 트레블월렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.balancedSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



class Result {

    /*
     * Complete the 'balancedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int balancedSum(List<Integer> arr) {
        // Write your code here
        int[] dp = new int[arr.size()];
        int[] sum = new int[arr.size()];
        sum[arr.size()-1] = arr.get(arr.size()-1);
        dp[0] = arr.get(0);
        for( int i = 1; i<arr.size(); i++){
            dp[i]=dp[i-1]+arr.get(i);
        }

        for(int i = arr.size()-2; i>=0; i--){
            sum[i] = sum[i+1] +arr.get(i);
        }

        for( int i = 1; i<arr.size()-1; i++){
            if(dp[i]==sum[i]) return arr.get(i);
        }
        return -1;
    }

}
