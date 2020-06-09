package leetcode.editor.cn.top100;

//[461]汉明距离
//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算


import org.junit.Test;

public class T461 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        Solution s = new Solution();
        int distance = s.hammingDistance4(1, 4);
        System.out.println(distance);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }

        public int hammingDistance2(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                if (xor % 2 == 1) {
                    distance++;
                }
                xor = xor >> 1;
            }
            return distance;
        }

        public int hammingDistance3(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                if (xor % 2 == 1) {
                    distance++;
                }
                xor = xor / 2;
            }
            return distance;
        }

        public int hammingDistance4(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                distance += 1;
                xor = xor & (xor - 1);
            }
            return distance;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}