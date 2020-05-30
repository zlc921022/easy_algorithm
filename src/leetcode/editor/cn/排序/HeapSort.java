package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * 堆排序
 * @author zlc
 * @created 2020/05/29
 */
public class HeapSort {

    @Test
    public void test() {
        int[] arr = {0, 2, 4, 4, 3, 3, 2};
        sort2(arr);
    }

    public void sort2(int[] arr) {
        System.out.println("排序前：");
        ArrayUtils.print(arr);
        // 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        // 构建最大堆
        System.out.println("构建最大堆：");
        ArrayUtils.print(arr);
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            ArrayUtils.swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
        System.out.println("排序后：");
        ArrayUtils.print(arr);
    }


    private void adjustHeap(int[] arr, int i, int length) {
        int k;
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int j = i * 2 + 1; j < length; j = k) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                //如果左子结点小于右子结点，j指向右子结点
                j++;
            }
            // 如果子节点大于父节点 则交换子节点和父节点的值
            // 同时i重新赋值为子节点的位置，目的是为了判断子节点是否符合大顶堆
            if (arr[j] > arr[i]) {
                ArrayUtils.swap(arr, j, i);
                i = j;
            }
            // 重新计算当前节点的左子节点
            k = j * 2 + 1;
        }
    }


    public void sort(int[] arr) {
        createBigHeap(arr);
        ArrayUtils.print(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            ArrayUtils.swap(arr, i, 0);
            heapify(arr, 0, i);
        }
        System.out.println("排序后：");
        ArrayUtils.print(arr);
    }

    private void createBigHeap(int[] arr) {
        int p;
        for (int i = 0; i < arr.length; i++) {
            p = i;
            while (p > 0) {
                if (arr[p] > arr[(p - 1) / 2]) {
                    ArrayUtils.swap(arr, p, (p - 1) / 2);
                    p = (p - 1) / 2;
                } else {
                    break;
                }
            }
        }
    }

    private void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        if (l < size && arr[l] > arr[i] && arr[l] >= arr[r]) {
            ArrayUtils.swap(arr, l, i);
            heapify(arr, l, size);
        }
        if (r < size && arr[r] > arr[i] && arr[r] >= arr[l]) {
            ArrayUtils.swap(arr, r, i);
            heapify(arr, r, size);
        }
    }

}
