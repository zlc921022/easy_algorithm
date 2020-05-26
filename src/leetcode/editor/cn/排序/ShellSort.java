package leetcode.editor.cn.排序;

import org.junit.Test;

/**
 * @author zlc
 * @created 2020/05/24
 */
public class ShellSort {

    @Test
    public void test() {

        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序前： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        sort(array);
        System.out.println("排序后： ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void sort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            // 增量每次减半
            gap = gap / 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j++) {
                    // 这个循环里其实就是一个插入排序
                    int insert = arr[j];
                    int k = j - gap;
                    for (; k >= 0 && insert < arr[k]; k -= gap) {
                        arr[k + gap] = arr[k];
                    }
                    arr[k + gap] = insert;
                }
            }
        }
    }
}
