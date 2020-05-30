package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * 归并排序
 * @author zlc
 * @created 2020/05/28
 */
public class MergeSort {

    private int[] temp;

    @Test
    public void test() {
        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        ArrayUtils.print(arr);
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    private void merge(int[] arr, int left, int right, int mid) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        for (int k = 0; k + left <= right; k++) {
            arr[left + k] = temp[k];
        }
    }
}
