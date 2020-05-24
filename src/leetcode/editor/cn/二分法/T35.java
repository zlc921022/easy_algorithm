package leetcode.editor.cn.二分法;

//[35]搜索插入位置
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找


import org.junit.Test;

public class T35 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] arr = {1, 3, 5, 6};
        int target = 7;
        Solution s = new Solution();
        int insert = s.searchInsert2(arr, target);
        System.out.println(insert);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 循环遍历 如果找到了就返回，没找到就继续找比当前值小并且比当前值大的那个index
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    index = i;
                    break;
                }
                if (i < nums.length - 1 && target > nums[i]
                        && target < nums[i + 1]) {
                    index = i + 1;
                }
            }
            if (target > nums[nums.length - 1]) {
                return nums.length;
            }
            return index;
        }


        /**
         * 二分查找 找到了就是index  没找到就是left
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert2(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            int index = -1;
            while (left <= right){
                int mid = (left + right) / 2;
                if(target == nums[mid]){
                    index = mid;
                    break;
                }else if(target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(index == -1){
                return left;
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}