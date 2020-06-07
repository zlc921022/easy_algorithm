package leetcode.editor.cn.周赛._191;

import leetcode.editor.cn.排序.ArrayUtils;
import org.junit.Test;

/**
 * @author zlc
 * @created 2020/05/31
 */
public class T191 {

    @Test
    public void test() {
//        int[] nums = {3, 7};
//        int max = maxProduct(nums);
//        System.out.println(max);
        /**
         * 3
         6
         [2]
         [5,3,1]
         */
        int[] horizontalCuts = {3,1,2};
        int[] verticalCuts = {1};
        int maxArea = maxArea(5, 2, horizontalCuts, verticalCuts);
        System.out.println(maxArea);
    }

    public int maxProduct(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = (nums[i] - 1) * (nums[j] - 1);
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }


    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if (horizontalCuts.length == 1 && verticalCuts.length == 1) {
            return horizontalCuts[0] * verticalCuts[0] % (10 ^ 9 + 7);
        }
        int m, k;
        if (horizontalCuts.length == 1) {
            m = h - horizontalCuts[0];
            quickSort(verticalCuts,0,verticalCuts.length - 1);
            k = verticalCuts[0];
            for (int i = 1; i < verticalCuts.length; i++) {
                int flag = Math.abs(verticalCuts[i] - verticalCuts[i - 1]);
                if (flag > k) {
                    k = flag;
                }
            }
            return m * k % (10 ^ 9 + 7);
        } else if (verticalCuts.length == 1) {
            quickSort(horizontalCuts,0,horizontalCuts.length - 1);
            m = horizontalCuts[0];
            k = w - verticalCuts[0];
            for (int i = 1; i < horizontalCuts.length; i++) {
                int flag = Math.abs(horizontalCuts[i] - horizontalCuts[i - 1]);
                if (flag > m) {
                    m = flag;
                }
            }
            return m * k % (10 ^ 9 + 7);
        } else {
            quickSort(horizontalCuts,0,horizontalCuts.length - 1);
            quickSort(verticalCuts,0,verticalCuts.length - 1);
            m = horizontalCuts[0];
            k = verticalCuts[0];
            for (int i = 1; i < horizontalCuts.length; i++) {
                int flag = Math.abs(horizontalCuts[i] - horizontalCuts[i - 1]);
                if (flag > m) {
                    m = flag;
                }
            }
            for (int i = 1; i < verticalCuts.length; i++) {
                int flag = Math.abs(verticalCuts[i] - verticalCuts[i - 1]);
                if (flag > k) {
                    k = flag;
                }
            }
            return m * k % (10 ^ 9 + 7);
        }
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    /**
     * 啊哈算法书上面的写法
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int ran = (int) (Math.random() * (right - left + 1) + left);
        ArrayUtils.swap(arr, left, ran);
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            //右边开始扫描,直到找到一个比v小的数值,否则j--
            while (arr[j] >= pivot && i < j)
                j--;
            //左边开始扫描，直到找到一个比v大的数值，否则i++ i不能等于r 因为后面i++就会数组越界
            while (arr[i] <= pivot && i < j)
                i++;
            if (i < j) {
                ArrayUtils.swap(arr, i, j);
            }
        }
        // i==j 时候位置数据和基准值位置互换 这样基准值左边的数据都小于基准值 右边数据都大于基准值了
        ArrayUtils.swap(arr, left, i);
        return i;
    }
}
