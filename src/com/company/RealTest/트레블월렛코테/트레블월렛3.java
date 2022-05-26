package com.company.RealTest.트레블월렛코테;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class 트레블월렛3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int limit = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result =  topArticles(limit);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }



    /*
     * Complete the 'topArticles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER limit as parameter.
     * base url for copy/paste:
     * https://jsonmock.hackerrank.com/api/articles?page=<pageNumber>
     */

    public static List<String> topArticles(int limit) throws IOException{
        List<String> ans = new LinkedList<>();
        String burl ="https://jsonmock.hackerrank.com/api/articles?page=";
        int start =1;
        String curl = burl+start;

        URL url = new URL(curl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int code = httpURLConnection.getResponseCode();

        httpURLConnection.disconnect();

        return ans;
    }
}

