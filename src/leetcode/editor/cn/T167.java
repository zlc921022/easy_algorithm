package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//[167]两数之和 II - 输入有序数组
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找


public class T167 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int targets = 8;
        Solution s = new Solution();
        int[] temp = s.twoSum(numbers, targets);
        if (temp != null) {
            System.out.println(temp[0] + "," + temp[1]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            return twoSum4(numbers, target);
        }

        /**
         * 冒泡 时间复杂度n^2 空间复杂度O(1)
         *
         * @param numbers
         * @param target
         * @return
         */
        private int[] twoSum1(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0) {
                return null;
            }
            int[] temp = new int[2];
            k:
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] + numbers[j] == target) {
                        temp[i] = i + 1;
                        temp[j] = j + 1;
                        break k;
                    }
                }
            }
            return temp;
        }

        /**
         * 空间换时间 时间复杂度n 空间复杂度n
         *
         * @param numbers
         * @param target
         * @return
         */
        private int[] twoSum2(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            int[] temp = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if (map.get(target - numbers[i]) != null) {
                    temp[0] = map.get(target - numbers[i]);
                    temp[1] = i + 1;
                    break;
                } else {
                    map.put(numbers[i], i + 1);
                }
            }
            return temp;
        }


        /**
         * 调用系统二分查找 时间复杂度n*logn 空间复杂度O(1)
         *
         * @param numbers
         * @param target
         * @return
         */
        private int[] twoSum3(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0) {
                return null;
            }
            int[] temp = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                int search = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
                if (search > 0) {
                    temp[0] = i + 1;
                    temp[1] = search + 1;
                    break;
                }
            }
            return temp;
        }

        /**
         * 手写二分查找 时间复杂度n*logn 空间复杂度O(1)
         *
         * @param numbers
         * @param target
         * @return
         */
        private int[] twoSum4(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0) {
                return null;
            }
            int[] temp = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                int search = target - numbers[i];
                int left = i + 1;
                int right = numbers.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (search > numbers[mid]) {
                        left = mid + 1;
                    } else if (search < numbers[mid]) {
                        right = mid - 1;
                    } else {
                        temp[0] = i + 1;
                        temp[1] = mid + 1;
                        return temp;
                    }
                }
            }
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}