package leetcode.editor.cn.字符串;

//[344]反转字符串
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串


import org.junit.Test;

public class T344 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        Solution s = new Solution();
        char[] arr = {'H', 'e', 'l', 'l', 'o'};
        s.reverseString4(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 首尾交换
         *
         * @param s
         */
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length; i++) {
                if (i == s.length / 2) {
                    break;
                }
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
        }

        /**
         * 优化1 直接遍历到中间
         *
         * @param s
         */
        public void reverseString2(char[] s) {
            for (int i = 0; i <= s.length / 2; i++) {
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
        }

        /**
         * 优化2 中间数字作为临时变量
         *
         * @param s
         */
        public void reverseString3(char[] s) {
            char temp = s[s.length / 2];
            for (int i = 0; i <= s.length / 2; i++) {
                s[s.length / 2] = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = s[s.length / 2];
            }
            s[s.length / 2] = temp;
        }

        /**
         * 优化4 参考交换两个数字
         *
         * @param s // 1,2   a = 3  b = 63
         *          // 1. a = a + b = 66
         *          // 2. b = a - b = 3
         *          // 3. a = a - b = 63
         */
        public void reverseString4(char[] s) {
            for (int i = 0; i < s.length / 2; i++) {
                // 不同字符才交换
                if (s[i] != s[s.length - 1 - i]) {
                    s[i] = (char) (s[i] + s[s.length - 1 - i]);
                    s[s.length - 1 - i] = (char) (s[i] - s[s.length - 1 - i]);
                    s[i] = (char) (s[i] - s[s.length - 1 - i]);
                }
            }
            printArr(s);
        }

        public void printArr(char[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}