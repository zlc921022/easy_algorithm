package leetcode.editor.cn.top100;

import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//[113]路径总和 II
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
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
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


public class T113 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode();
        treeNode.add(5);
        treeNode.add(3);
        treeNode.add(1);
        treeNode.add(2);
        treeNode.add(9);
        treeNode.add(7);
        treeNode.add(10);
        treeNode.printTreeNode();

        Solution s = new Solution();
        s.dfs(treeNode, 9,new ArrayDeque<>(),new ArrayList<>());
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return null;
            }
            List<List<Integer>> list = new ArrayList<>();
            if (isLeafNode(root)) {
                ArrayList<Integer> list1 = new ArrayList<>(root.val);
                list.add(list1);
                return list;
            }
            int temp = root.val;
            List<Integer> left = pathSum(root.left, sum, new ArrayList<>(), 0, temp);
            List<Integer> right = pathSum(root.right, sum, new ArrayList<>(), 0, temp);
            list.add(left);
            list.add(right);
            return list;
        }

        public void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
            if (node == null) {
                return;
            }
            sum -= node.val;
            path.add(node.val);
            if (node.left == null && node.right == null && sum == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            if (node.left != null) {
                dfs(node.left, sum, path, res);
                path.removeLast();
            }

            if (node.right != null) {
                dfs(node.right, sum, path, res);
                path.removeLast();
            }
        }

        public List<Integer> pathSum(TreeNode root, int sum, List<Integer> list, int p, int temp) {
            if (root == null) {
                return null;
            }
            if (p == 0) {
                list.add(temp);
            }
            temp += root.val;
            if (p > 0 && p <= list.size()) {
                for (int i = 1; i < p; i++) {
                    temp += list.get(i);
                }
            }
            if (temp == sum && isLeafNode(root)) {
                list.add(root.val);
                return list;
            } else if (!isLeafNode(root)) {
                list.add(root.val);
            }
            pathSum(root.left, sum, list, p + 1, temp);
            pathSum(root.right, sum, list, p + 1, temp);
            return list;
        }

        private boolean isLeafNode(TreeNode root) {
            return root.right == null && root.left == null;
        }

        private void printList(List list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}