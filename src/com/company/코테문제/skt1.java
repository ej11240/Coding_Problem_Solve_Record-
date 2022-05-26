package com.company.코테문제;


import java.util.*;


public class skt1 {
    public static void main(String[] args) {

        int[] t = {3,5,2,9,8};
        int m=3;

        int answer = 0;
        quickSort(t,0,t.length-1);

        for(int i =0; i<m; i++){
            answer+=t[i];
        }
        answer+=m;
        System.out.println(answer);



    }
    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }


}
