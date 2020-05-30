package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * 快速排序
 *
 * @author zlc
 * @created 2020/05/26
 */
public class QuickSort {

    @Test
    public void test() {

        int[] array = new int[100];
        System.out.println("排序前： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        int[] brr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            brr[i] = i;
        }
        long startTime = System.currentTimeMillis();
        quickSort(brr, 0, array.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间：" + (endTime - startTime));
        System.out.println("排序后： ");
        for (int value : brr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

//    public int[] sortedSquares(int[] A) {
//        return quickSort(A,0,A.length - 1);
//    }

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

    /**
     * 菜鸟教程写法
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition1(int[] arr, int left, int right) {
        int ran = (int) (Math.random() * (right - left + 1) + left);
        ArrayUtils.swap(arr, left, ran);
        int pivot = arr[left];
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < pivot) {
                ArrayUtils.swap(arr, i, index);
                index++;
            }
        }
        ArrayUtils.swap(arr, left, index - 1);
        return index - 1;
    }

    private int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
        }
        arr[r] = pivot;
        return r;
    }
}
