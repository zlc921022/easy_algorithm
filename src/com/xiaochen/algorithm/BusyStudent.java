package com.xiaochen.algorithm;

import org.junit.Test;

public class Solution1 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null || startTime.length == 0) {
            return 0;
        }
        if (endTime == null || endTime.length == 0) {
            return 0;
        }

        if (startTime.length != endTime.length) {
            return 0;
        }

        int sum =0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                sum++;
            }
        }
        return sum;
    }

    @Test
    public void test(){
        int[] startTime = new int[]{9,8,7,6,5,4,3,2,1};
        int[] endTime = new int[]{10,10,10,10,10,10,10,10,10};
        int queryTime = 5;
        Solution1 s = new Solution1();
        int sum = s.busyStudent(startTime, endTime, queryTime);
        System.out.println(sum);
    }

}