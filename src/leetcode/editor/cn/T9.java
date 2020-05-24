package leetcode.editor.cn;

//[9]回文数
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T9 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int a = -121;
        Solution s = new Solution();
        boolean sPalindrome = s.isPalindrome2(a);
        System.out.println(sPalindrome);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 转成字符串 判断收尾字符是否相等
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            // 1221
            char[] arr = String.valueOf(x).toCharArray();
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != arr[arr.length - i - 1]) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 调用系统api
         * @param x
         * @return
         */
        public boolean isPalindrome2(int x) {
            StringBuilder sb = new StringBuilder();
            sb.append(x);
            return sb.reverse().toString().equals(x + "");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}