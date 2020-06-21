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
        treeNode.add(4);
        treeNode.add(9);
        treeNode.add(7);
        treeNode.add(10);
        treeNode.printTreeNode();

        Solution s = new Solution();
        s.dfs(treeNode.root, 9, new ArrayDeque<>(), new ArrayList<>());

        int fun = s.depth(treeNode.root);
        System.out.println(fun);
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

        public int fun(int n) {
            if (n == 0) {
                return 1;
            } else if(n == 1){
                return 2;
            } else {
                return 2 * fun(n - 1);
            }
        }

        public int depth(TreeNode node){
            if(node == null){
                return 0;
            }
            int l = depth(node.left);
            int r = depth(node.right);
            int result = Math.max(l, r) + 1;
            System.out.println("result: " + result +" : node.val: " + node.val);
            return result;
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return null;
            }
            List<List<Integer>> list = new ArrayList<>();
            sum = sum - root.val;
            List<Integer> left = pathSum(root.left, sum, new ArrayList<>());
            List<Integer> right = pathSum(root.right, sum, new ArrayList<>());
            if( !left.isEmpty()) {
                list.add(left);
            }
            if( !right.isEmpty()) {
                list.add(right);
            }
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

        public List<Integer> pathSum(TreeNode root, int sum, List<Integer> list) {
            if (root == null) {
                return new ArrayList<>();
            }
            sum -= root.val;
            list.add(root.val);
            if (isLeafNode(root)) {
                if (sum == 0) {
                    return list;
                } else {
                    list.clear();
                }
            }
            pathSum(root.left, sum, list);
            pathSum(root.right, sum, list);
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