package leetcode.editor.cn;

//[110]平衡二叉树
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索


import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class T110 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        TreeNode node = new TreeNode();
        node.add(9);
        node.add(3);
        node.add(20);
        node.add(15);

        Solution s = new Solution();
        boolean isBalanced = s.isBalanced(node.root);
        System.out.println(isBalanced);
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

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            boolean isBalanced = true;
            while ( !deque.isEmpty()){
                TreeNode node = deque.removeFirst();
                if(sumDepth(node.left) > 1 || sumDepth(node.right) > 1){
                    isBalanced = false;
                    break;
                }
                if (node.left != null) {
                    deque.add(node.left);
                    node.left = null;
                }
                if (node.right != null) {
                    deque.add(node.right);
                    node.right = null;
                }
            }
            return isBalanced;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }

        private int depth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left == null) {
                return sumDepth(root.right);
            } else if (root.right == null) {
                return sumDepth(root.left);
            } else {
                return sumDepth(root);
            }
        }

        private int sumDepth(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            int minDepth = 1, maxDepth = 1;
            boolean isMin = false;
            while (!deque.isEmpty()) {
                Deque<TreeNode> deque1 = new LinkedList<>();
                while (!deque.isEmpty()) {
                    TreeNode node = deque.removeFirst();
                    if(node == null){
                        continue;
                    }
                    if (!isMin && (node.left == null && node.right == null)) {
                        isMin = true;
                    }
                    if (node.left != null) {
                        deque1.add(node.left);
                        node.left = null;
                    }
                    if (node.right != null) {
                        deque1.add(node.right);
                        node.right = null;
                    }
                }
                deque = deque1;
                if (!isMin) {
                    minDepth++;
                }
                if (!deque1.isEmpty()) {
                    maxDepth++;
                }
            }
            return Math.abs(maxDepth - minDepth);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}