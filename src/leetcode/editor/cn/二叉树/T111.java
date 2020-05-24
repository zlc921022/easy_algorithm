package leetcode.editor.cn.二叉树;

//[111]二叉树的最小深度
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class T111 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode();
        treeNode.add(3);
        treeNode.add(1);
        treeNode.add(2);
//        treeNode.add(2);
        treeNode.add(4);
//        treeNode.add(5);
//        treeNode.add(5);
//        treeNode.add(2);
//        treeNode.add(2);
//        treeNode.add(1);
//        treeNode.add(4);

        Solution s = new Solution();
        int min = s.minDepth(treeNode.root);
        System.out.println(min);
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
        public int minDepth(TreeNode root) {
            return minDepth2(root);
        }

        /**
         * 递归 左右子树最小深度+1
         *
         * @param root 根节点
         * @return
         */
        private int minDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lDepth, rDepth;
            lDepth = minDepth1(root.left);
            rDepth = minDepth1(root.right);
            if (lDepth == 0 && rDepth == 0) {
                return 1;
            } else if (rDepth == 0) {
                return lDepth + 1;
            } else if (lDepth == 0) {
                return rDepth + 1;
            }
            return Math.min(lDepth, rDepth) + 1;
        }

        /**
         * 非递归 通过队列遍历
         *
         * @param root
         * @return
         */
        private int minDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            int sum = 1;
            i:
            while (!deque.isEmpty()) {
                Deque<TreeNode> deque1 = new LinkedList<>();
                while (!deque.isEmpty()) {
                    TreeNode node = deque.removeFirst();
                    if (node.left == null && node.right == null) {
                        break i;
                    }
                    if(node.left != null){
                        deque1.add(node.left);
                        node.left = null;
                    }
                    if(node.right != null){
                        deque1.add(node.right);
                        node.right = null;
                    }
                }
                deque = deque1;
                sum++;
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}