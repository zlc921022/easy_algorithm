package leetcode.editor.cn;

//[345]反转字符串中的元音字母
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


import org.junit.Test;

public class T345 {

    public static void main(String[] args) {
    }

    @Test
    public void test() {
        String str = "hello";
        Solution s = new Solution();
        String s1 = s.reverseVowels(str);
        System.out.println(s1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] arr = s.toCharArray();
            int k = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                for (int j = arr.length - 1 - k; j >= arr.length / 2; j--) {
                    if(arr[i] == arr[j]){
                        k++;
                        break;
                    }
                    if (isVowel(arr[i]) && isVowel(arr[j])) {
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return new String(arr);
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}