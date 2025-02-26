package leetcode.editor.cn.top100;

//[283]移动零
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


import leetcode.editor.cn.排序.ArrayUtils;
import org.junit.Test;

public class T283 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        Solution s = new Solution();
        s.moveZeroes1(nums);
        ArrayUtils.print(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int p = 0, i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[p];
                    nums[p++] = temp;
                }
            }
        }

        public void moveZeroes1(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                // 非0数据加入到数组中 k 从0开始
                if (nums[i] != 0) {
                    nums[k++] = nums[i];
                }
            }
            // k到数组长度之后全部填0 因为非0数据都已经加入到0-k范围了
            for (int i = k; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}