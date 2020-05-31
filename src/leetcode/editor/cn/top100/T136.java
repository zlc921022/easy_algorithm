package leetcode.editor.cn.top100;

//[136]只出现一次的数字
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表


import org.junit.Test;

import java.util.HashMap;

public class T136 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] arr = {4,1,2,1,2};
        Solution s = new Solution();
        int number = s.singleNumber1(arr);
        System.out.println(number);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int value = map.get(nums[i]);
                    map.put(nums[i], value + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for (int key : map.keySet()) {
                Integer value = map.get(key);
                if (value == 1) {
                    return key;
                }
            }
            return 0;
        }

        /**
         * 0 和任何数做异或运算 等于任何数
         * 任何数和自身做异或运算 等于 0
         */
        public int singleNumber1(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single = single ^ num;
            }
            return single;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}