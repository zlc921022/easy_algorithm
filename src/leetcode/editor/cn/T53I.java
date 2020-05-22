package leetcode.editor.cn;

//[面试题53 - I]在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = yes, target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T53I {

    public static void main(String[] args) {

    }


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 3, 3, 3};
        int target = 3;
        Solution s = new Solution();
        int search = s.search2(arr, target);
        System.out.print(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    if (map.containsKey(target)) {
                        map.put(target, map.get(target) + 1);
                    } else {
                        map.put(target, 1);
                    }
                }
            }
            return map.isEmpty() ? 0 : map.get(target);
        }

        /**
         * 直接搜索判断
         * @param nums
         * @param target
         * @return
         */
        public int search3(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int num : nums) {
                if (target == num) {
                    sum++;
                }
            }
            return sum;
        }


        /**
         * 手写二分查找 时间复杂度n*logn 空间复杂度O(1)
         *
         * @param numbers
         * @param target
         * @return
         */
        private int search2(int[] numbers, int target) {
            if (numbers == null || numbers.length == 0) {
                return 0;
            }
            int l = 0, r = 0;
            boolean isFind = false;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == target && !isFind) {
                    isFind = true;
                    l = i;
                }
                int left = i + 1;
                int right = numbers.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (target > numbers[mid]) {
                        left = mid + 1;
                    } else if (target < numbers[mid]) {
                        right = mid - 1;
                    } else if (isFind) {
                        left++;
                        r = mid;
                    } else {
                        r = mid;
                        break;
                    }
                }
            }
            int abs = Math.abs((r - l));
            return isFind ? abs + 1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}