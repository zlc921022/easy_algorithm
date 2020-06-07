package leetcode.editor.cn.周赛._192;

import java.util.Arrays;

/**
 * @author zlc
 * @created 2020/06/07
 */
public class T192 {


    /**
     * 5428. 重新排列数组
     *
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     输入：nums = [2,5,1,3,4,7], n = 3
     输出：[2,3,5,4,1,7]
     解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        if (2 * n != nums.length) {
            return null;
        }
        int s = 0;
        int arr[] = new int[nums.length];
        for (int i = 0; i < n; i++) {
            arr[s++] = nums[i];
            arr[s++] = nums[n + i];
        }
        return arr;
    }

    /**
     * 5429. 数组中的 k 个最强值
     * 给你一个整数数组 arr 和一个整数 k 。

     设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：

      |arr[i] - m| > |arr[j] - m|
      |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
     请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。

     输入：arr = [1,2,3,4,5], k = 2
     输出：[5,1]
     解释：中位数为 3，按从强到弱顺序排序后，数组变为 [5,1,4,2,3]。最强的两个元素是 [5, 1]。[1, 5] 也是正确答案。
     注意，尽管 |5 - 3| == |1 - 3| ，但是 5 比 1 更强，因为 5 > 1

     * @param arr
     * @param k
     * @return
     */
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[] temp = new int[k];
        int[] brr = new int[arr.length];
        sort(arr,0,arr.length - 1,brr,m);
        System.arraycopy(arr, 0, temp, 0, temp.length);
        return temp;
    }

    public void sort(int[] arr, int left, int right,int[] brr,int m) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid,brr,m);
        sort(arr, mid + 1, right,brr,m);
        merge(arr, left, right, mid,brr,m);
    }

    private void merge(int[] arr, int left, int right, int mid,int[] brr,int m) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (Math.abs(arr[i] - m) < Math.abs(arr[j] - m) ||
                    (Math.abs(arr[i] - m) == Math.abs(arr[j] - m) && arr[i] < arr[j])){
                brr[t++] = arr[j++];
            }else{
                brr[t++] = arr[i++];
            }
        }
        while (i <= mid) {
            brr[t++] = arr[i++];
        }
        while (j <= right) {
            brr[t++] = arr[j++];
        }

        for (int k = 0; k + left <= right; k++) {
            arr[left + k] = brr[k];
        }
    }
}
