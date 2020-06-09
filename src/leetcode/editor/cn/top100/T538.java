package leetcode.editor.cn.top100;

//[538]把二叉搜索树转换为累加树
//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树


import leetcode.editor.cn.二叉树.TreeNode;
import leetcode.editor.cn.排序.ArrayUtils;
import org.junit.Test;

public class T538 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode();
        treeNode.add(5);
        treeNode.add(2);
        treeNode.add(13);
//
        treeNode.printTreeNode();
        Solution s = new Solution();
        treeNode = s.convertBST(treeNode.root);
        treeNode.printTreeNode();
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

        /**
         * BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.
         *
         * @param root
         * @return
         */
        int num;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 遍历右子树
            convertBST(root.right);
            // 遍历顶点
            root.val += num;
            num = root.val;
            // 遍历左子树
            convertBST(root.left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}