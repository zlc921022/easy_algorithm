package leetcode.editor.cn.字符串;

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
        String str = "Sore was I ere I saw Eros.";
        System.out.println(str);
        Solution s = new Solution();
        String s1 = s.reverseVowels2(str);
        System.out.println(s1);
        System.out.println("----");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] arr = s.toCharArray();
            int k = 0;
            for (int i = 0; i < arr.length - k; i++) {
                for (int j = arr.length - 1 - k; j >= 0; j--) {
                    if (isVowel(arr[i]) && isVowel(arr[j])) {
                        if (arr[i] != arr[j]) {
                            char temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                        k = arr.length - j;
                        break;
                    }
                }
            }
            return new String(arr);
        }


        /**
         * 双指针 一个从左边开始 一个右边开始
         * 如果左边是元音字母 右边也是元音字母 如果元音字母不相同 则交换两个元音字母 左指针+1，右指针-1
         * 如果左边是元音字母，右边不是元音字母 则只对右指针-1
         * 如果左边不是元音字母，则做指针+1
         * @param s
         * @return
         */
        public String reverseVowels2(String s) {
            char[] arr = s.toCharArray();
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                // 如果左边是元音字母
                if (isVowel(arr[left])) {
                    // 如果右边是元音字母
                    if (isVowel(arr[right])) {
                        if (arr[left] != arr[right]) {
                            char temp = arr[left];
                            arr[left] = arr[right];
                            arr[right] = temp;
                        }
                        left++;
                        right--;
                    } else {
                        right--;
                    }
                } else {
                    left++;
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