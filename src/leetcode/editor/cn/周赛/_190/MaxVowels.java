package leetcode.editor.cn.周赛._190;

import org.junit.Test;

/**
 * @author zlc
 * @created 2020/05/24
 */
public class MaxVowels {

    @Test
    public void test() {

        String str = "novowels";
        int k = 1;
        Solution s = new Solution();
        int max = s.maxVowels(str, k);
        System.out.println(max);
    }

    class Solution {
        /**
         * // abciiidef k = 3
         * //abc
         * //  bci
         * //   cii
         * //    iii
         * 双指针
         *
         * @param s
         * @param k
         * @return
         */
        public int maxVowels(String s, int k) {
            int count = 0;
            int max = 0;
            char[] arr = s.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (isVowel(arr[j])) {
                    count++;
                }
                if (j >= k && isVowel(arr[j - k])) {
                    count--;
                }
                max = Math.max(count,max);
            }
            return max;
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
