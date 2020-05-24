package leetcode.editor.cn.字符串;

//[557]反转字符串中的单词 III
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串


import org.junit.Test;

public class T557 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        String str = "Let's take LeetCode contest";
        Solution s = new Solution();
        String s1 = s.reverseWords(str);
        System.out.println(s1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] srr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < srr.length; i++) {
                String s1 = srr[i];
                char[] array = s1.toCharArray();
                for (int j = 0; j < array.length / 2; j++) {
                    char temp = array[j];
                    array[j] = array[array.length - j - 1];
                    array[array.length - j - 1] = temp;
                }
                if (i != srr.length - 1) {
                    sb.append(new String(array)).append(" ");
                } else {
                    sb.append(new String(array));
                }
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}