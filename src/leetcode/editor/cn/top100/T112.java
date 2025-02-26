package leetcode.editor.cn.top100;

import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

//[112]路径总和
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索


public class T112 {

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
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null){
                return false;
            }
            sum -= root.val;
            if(root.left == null && root.right == null){
                return sum == 0 ;
            }
            return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
        }

        private boolean isEqual(List<Integer> list, int sum){
            int temp = 0;
            for (Integer value : list) {
                temp += value;
            }
            return temp == sum;
        }

        public boolean hasPathSum1(TreeNode root, int sum) {
            return hasPathSum(root,sum,new ArrayList<>(),0);
        }

        public boolean hasPathSum(TreeNode root, int sum, List<Integer> list, int p) {
            if (root == null) {
                return false;
            }
            int temp = root.val;
            if (p > 0) {
                for (int i = p - 1; i >= 0; i--) {
                    temp += list.get(i);
                }
            }
            if (temp == sum && root.left == null && root.right == null) {
                return true;
            }
            list.add(p,root.val);
            boolean l = hasPathSum(root.left, sum, list, p + 1);
            boolean r = hasPathSum(root.right, sum, list, p + 1);
            return l || r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}