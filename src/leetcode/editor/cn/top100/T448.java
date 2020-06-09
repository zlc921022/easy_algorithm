package leetcode.editor.cn.top100;

//[448]找到所有数组中消失的数字
//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组


import leetcode.editor.cn.排序.ArrayUtils;
import org.junit.Test;

import java.util.*;

public class T448 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution s = new Solution();
        List<Integer> list = s.findDisappearedNumbers2(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= nums.length; i++) {
                if(!set.contains(i)){
                    list.add(i);
                }
            }
            return list;
        }

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = Math.abs(nums[i]) - 1;
                nums[num] = - Math.abs(nums[num]);
            }
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0){
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}