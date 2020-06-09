package leetcode.editor.cn;

import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.util.List;

//[437]路径总和 III
//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树


public class T437 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int pathSum(TreeNode root, int sum) {
            return pathSum(root, sum, new int[1000], 0);
        }

        /**
         * 创建数组保存节点
         * @param root
         * @param sum
         * @param arr
         * @param p
         * @return
         */
        public int pathSum(TreeNode root, int sum, int[] arr, int p) {
            if (root == null) {
                return 0;
            }
            int temp = root.val;
            int n = temp == sum ? 1 : 0;
            if (p > 0) {
                for (int i = p - 1; i>= 0 ; i--) {
                    temp += arr[i];
                    if (temp == sum) {
                        n++;
                    }
                }
            }
            arr[p] = root.val;
            int l = pathSum(root.left, sum, arr, p + 1);
            int r = pathSum(root.right, sum, arr, p + 1);
            return n + l + r;
        }

        /**
         * 创建list保存其他节点
         * @param root
         * @param sum
         * @param list
         * @param p
         * @return
         */
        public int pathSum1(TreeNode root, int sum, List<Integer> list, int p) {
            if (root == null) {
                return 0;
            }
            int temp = root.val;
            int n = temp == sum ? 1 : 0;
            if (p > 0) {
                for (int i = p - 1; i>= 0 ; i--) {
                    temp += list.get(i);
                    if (temp == sum) {
                        n++;
                    }
                }
            }
            list.add(p,root.val);
            int l = pathSum1(root.left, sum, list, p + 1);
            int r = pathSum1(root.right, sum, list, p + 1);
            return n + l + r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}