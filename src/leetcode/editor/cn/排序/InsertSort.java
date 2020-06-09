package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * 插入排序
 * @author zlc
 * @created 2020/05/25
 */
public class InsertSort {

    @Test
    public void test() {
        int[] arr = {2, 6, 5, 4, 3, 9, 7, 1, 8};
        ArrayUtils.print(arr);
        System.out.println("-----------");
        sort(arr);
        ArrayUtils.print(arr);
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int insert, j;
        for (int i = 1; i < arr.length; i++) {
            insert = arr[i];
            for (j = i; j > 0 && insert < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = insert;
        }
    }
}
