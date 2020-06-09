package leetcode.editor.cn.top100;

//[104]二叉树的最大深度
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索


import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class T104 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        TreeNode node = new TreeNode();
        node.add(3);
        node.add(2);
        node.add(1);
        node.add(6);
        node.add(5);
        node.add(7);
        node.add(8);
        Solution s = new Solution();
        int maxDepth = s.maxDepth1(node.root);
        System.out.println(maxDepth);
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            int maxDepth = 0;
            while (!deque.isEmpty()) {
                Deque<TreeNode> deque1 = new LinkedList<>();
                while (!deque.isEmpty()) {
                    TreeNode node = deque.removeFirst();
                    if (node.left != null) {
                        deque1.push(node.left);
                        node.left = null;
                    }
                    if (node.right != null) {
                        deque1.push(node.right);
                        node.right = null;
                    }
                }
                deque = deque1;
                maxDepth++;
            }
            return maxDepth;
        }

        public int maxDepth1(TreeNode root) {
            if(root == null){
                return 0;
            }
            int lDepth = maxDepth1(root.left);
            int rDepth = maxDepth1(root.right);
            return Math.max(lDepth,rDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}