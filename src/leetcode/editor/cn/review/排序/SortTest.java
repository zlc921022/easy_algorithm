package leetcode.editor.cn.review.排序;

import leetcode.editor.cn.排序.ArrayUtils;
import org.junit.Test;

/**
 * @author zlc
 * @created 2020/06/27
 */
public class SortTest {

    @Test
    public void test() {
        int[] arr = {10, 7, 7, 6, 6, 20, 2, 1};
        shellSort(arr);
        ArrayUtils.print(arr);
    }

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ArrayUtils.swap(arr, i, j);
                }
            }
        }
    }


    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int insertData = arr[i];
            int j;
            for (j = i; j > 0 && insertData < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = insertData;
        }
    }

    public void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int gap = arr.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int insertData = arr[i];
                int j;
                for (j = i; j >= gap && insertData < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = insertData;
            }
            gap = gap / 2;
        }
    }

    public void quickSort() {

    }

    public void mergeSort() {

    }

    public void heapSort() {

    }


}
