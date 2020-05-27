package leetcode.editor.cn.排序;

import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;

import java.util.Random;

/**
 * @author zlc
 * @created 2020/05/26
 * 快拍
 */
public class QuickSort {

    @Test
    public void test() {

        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - 1- i;
        }
        System.out.println("排序前： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        long startTime = System.currentTimeMillis();
        System.out.println();
        quickSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime));
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
        int partition = partition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private int partition0(int[] arr, int left, int right){
        int ran = (int) (Math.random() * (right - left + 1) + left);
        swap(arr,left,ran);
        int pivot = arr[left];
        int j = left + 1;
        for (int i = j; i <= right; i++) {
            if(arr[i] < pivot){
                swap(arr,i,j++);
            }
        }
        swap(arr,left,j - 1);
        return j - 1;
    }

    private int partition(int[] arr, int left, int right) {
        int ran = (int) (Math.random() * (right - left + 1) + left);
        swap(arr,left,ran);
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if(i < j){
                swap(arr,i,j);
            }
        }
        swap(arr,left,j);
        return j;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
