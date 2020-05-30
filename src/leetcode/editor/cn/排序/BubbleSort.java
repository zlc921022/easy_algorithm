package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * 冒泡排序
 *
 * @author zlc
 * @created 2020/05/25
 */
public class BubbleSort {

    @Test
    public void test() {
        int[] arr = {2, 6, 5, 4, 3, 9, 7, 1, 8};
        ArrayUtils.print(arr);
        System.out.println("-----------");
        sort(arr);
        ArrayUtils.print(arr);
    }

    /**
     * 冒泡排序
     * 相邻的两个数一一比较
     *
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

}
