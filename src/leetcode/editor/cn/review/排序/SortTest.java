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
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        heapSort(arr);
        // ArrayUtils.print(arr);

        int[] brr = {1,2,3,4,5,6,7};
        int search = binarySearch(brr, 4);
        System.out.println(search);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
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

    /**
     * 选择排序
     *
     * @param arr
     */
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


    /**
     * 插入排序
     *
     * @param arr
     */
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

    /**
     * 希尔排序
     *
     * @param arr
     */
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

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partion = partion(arr, left, right);
            quickSort(arr, left, partion - 1);
            quickSort(arr, partion + 1, right);
        }
    }

    private int partion(int[] arr, int left, int right) {
        int v = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= v) {
                j--;
            }
            while (i < j && arr[i] <= v) {
                i++;
            }
            if (i < j) {
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, i, left);
        return i;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            arr[m + left] = temp[m];
        }
    }


    /**
     * 堆排序
     * @param arr
     */
    public void heapSort(int[] arr) {
        ArrayUtils.print(arr);
        // 构建大顶堆
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 构建最大堆
        System.out.println("构建最大堆：");
        ArrayUtils.print(arr);
        //2.调整堆结构 + 交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换堆顶元素与末尾元素
            ArrayUtils.swap(arr, 0, i);
            // 重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
        System.out.println("排序后：");
        ArrayUtils.print(arr);
    }

    private void adjustHeap(int[] arr, int i, int length) {
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                //如果左子结点小于右子结点，j指向右子结点
                j++;
            }
            // 如果子节点大于父节点 则交换子节点和父节点的值
            // 同时i重新赋值为子节点的位置，目的是为了判断子节点是否符合大顶堆
            if (arr[j] > arr[i]) {
                ArrayUtils.swap(arr, i, j);
                i = j;
            } else {
                break;
            }
        }
    }


    /**
     * 二分查找
     * @param arr
     * @param word
     * @return
     */
    public int binarySearch(int[] arr, int word) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (word == arr[mid]) {
                return mid;
            } else if (word < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
