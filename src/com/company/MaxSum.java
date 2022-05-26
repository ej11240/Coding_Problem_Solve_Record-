package com.company;

import java.util.List;
import java.util.Arrays;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int maxValue = list.get(0);
        int secondLargest = -1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                secondLargest = maxValue;
                maxValue = list.get(i);
            } else if (list.get(i) > secondLargest) {
                secondLargest = list.get(i);
            }
        }
        return maxValue+secondLargest;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11,123,435);
        // Should return 20, since 9 and 11 are the largest elements
        // and their sum is 20

        System.out.println(findMaxSum(list));
    }
}
//import java.util.List;
//import java.util.Arrays;
//
//public class MaxSum {
//    public static int findMaxSum(List<Integer> list) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
//    }
//
//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(5, 9, 7, 11);
//        // Should return 20, since 9 and 11 are the largest elements
//        // and their sum is 20
//        System.out.println(findMaxSum(list));
//    }
//}