package com.xiaochen.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public String arrangeWords(String text) {
        String[] strings = text.split(" ");
        Collections.sort(Arrays.asList(strings), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String s = Arrays.toString(strings);
        s = s.toLowerCase();
        s = s.substring(1, s.length() - 1);
        s= s.replace(",","");
        StringBuilder sb  = new StringBuilder();
        sb.append(strings[0].substring(0, 1).toUpperCase())
                .append(strings[0].substring(1,strings[0].length()))
                .append(s.substring(strings[0].length(),s.length()));
        return sb.toString();
    }


    private void quickSort(String[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        printArr(arr);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private int partition(String[] arr, int l, int r) {
        String v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            //左边开始扫描，直到找到一个比v大的数值，否则i++ i不能等于r 因为后面i++就会数组越界
            while (arr[i].length() < v.length() && i < r)
                i++;
            //右边开始扫描,直到找到一个比v小的数值,否则j--
            while (arr[j].length() > v.length() && j >= l)
                j--;
            if (i >= j) break;
            if (arr[l].length() != arr[j].length()) {
                swap(arr, i, j);
            }
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        String sb = arrangeWords("Leetcode is cool");
        System.out.println(sb);
    }

}