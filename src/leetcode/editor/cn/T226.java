package leetcode.editor.cn;

//[226]翻转二叉树
//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树


import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T226 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        TreeNode node = new TreeNode();
        node.add(4);
        node.add(2);
        node.add(1);
        node.add(3);
        node.add(7);
        node.add(6);
        node.add(9);
        node.printTreeNode();
        Solution s = new Solution();
        s.invertTree(node.root);
        node.printTreeNode();
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

        List<Integer> list;
        public TreeNode invertTree(TreeNode root) {
            return invert1(root);
        }

        /**
         * 左右节点交换
         *
         * @param root 根节点
         */
        private TreeNode invert(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode curr = root.left;
            root.left = invert(root.right);
            root.right = invert(curr);
            return root;
        }

        /**
         * 左右节点交换
         *
         * @param root 根节点
         */
        private TreeNode invert1(TreeNode root) {
            if (root == null) {
                return null;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                Deque<TreeNode> deque1 = new LinkedList<>();
                while (!deque.isEmpty()) {
                    TreeNode node = deque.removeFirst();
                    if(node == null){
                        continue;
                    }
                    TreeNode curr = node.left;
                    node.left = node.right;
                    node.right = curr;
                    deque1.add(node.left);
                    deque1.add(node.right);
                }
                deque = deque1;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}