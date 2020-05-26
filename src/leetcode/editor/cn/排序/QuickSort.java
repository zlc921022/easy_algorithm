package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * @author zlc
 * @created 2020/05/26
 * 快拍
 */
public class QuickSort {

    @Test
    public void test() {

        int[] array = {9,8,7,6,5,4,3,2,1};
        System.out.println("排序前： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition1(arr, start, arr.length - 1);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && arr[l] < pivot) {
                l++;
            }
            while (l < r && arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            if (arr[l] != arr[r]) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            } else {
                l++;
            }
        }
        return l;
    }

    private int partition1(int[] arr, int start, int end) {
        int pivot = arr[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }
}
