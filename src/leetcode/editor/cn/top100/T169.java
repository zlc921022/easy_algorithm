package leetcode.editor.cn.top100;

//[169]多数元素
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class T169 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        Solution s = new Solution();
         s.a();
        //System.out.println(element);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }

        public int majorityElement1(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for (int key : map.keySet()) {
                if (map.get(key) > nums.length / 2) {
                    return key;
                }
            }
            return 0;
        }

        public void a(){
            int[] arr = new int[53];
            String s= "ABCBDAAFGHabcc";
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 65;
                arr[index]++;
            }
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] != 0 ){
                    System.out.println((char) (i + 65) + " count= " + arr[i] + " ");
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}