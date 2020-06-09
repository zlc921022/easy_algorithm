package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * 选择排序
 *
 * @author zlc
 * @created 2020/05/25
 */
public class SelectSort {

    @Test
    public void test() {
        int[] arr = {2, 6, 5, 4, 3, 9, 7, 1, 8};
        ArrayUtils.print(arr);
        System.out.println("-----------");
        sort(arr);
        ArrayUtils.print(arr);
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (arr[i] > arr[min]) {
                ArrayUtils.swap(arr, i, min);
            }
        }
    }

    /**
     * 选择排序
     * 用后面的数一一和当前数值比较
     * @param arr
     */
    public void sort2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    ArrayUtils.swap(arr,i,j);
                }
            }
        }
    }

}
