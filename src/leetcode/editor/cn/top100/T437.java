package leetcode.editor.cn.top100;

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


import leetcode.editor.cn.二叉树.TreeNode;
import leetcode.editor.cn.排序.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T437 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
//        TreeNode node = new TreeNode();
//        node.add(10);
//        node.add(5);
//        node.add(3);
//        node.add(2);
//////        node.add(1);
////        node.add(9);
////        node.add(8);
////        node.add(7);
//
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




        int num = 0;

        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int result = countPath(root, sum);
            int a = pathSum(root.left, sum);
            int b = pathSum(root.right, sum);
            return result + a + b;
        }

        private int countPath(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            sum = sum - root.val;
            int result = (sum == 0) ? 1 : 0;
            return result + countPath(root.left, sum) + countPath(root.right, sum);
        }

        private int preNode(TreeNode root, int sum) {
            int num = 0;
            if (root.val == sum) {
                num++;
            }
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<>();
            if (root.val == sum || root.val > sum) {
                stack.add(root.left);
            } else {
                stack.add(root);
            }
            while (!stack.isEmpty()) {
                Stack<TreeNode> stack1 = new Stack<>();
                TreeNode peek = stack.peek();
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    if (node.right != null) {
                        if (pre != null && node.right.val + pre.val + node.val == sum) {
                            num++;
                        } else if (node.right.val + node.val == sum) {
                            num++;
                        }
                        stack1.add(node.right);
                    }
                    if (node.left != null) {
                        if (pre != null && node.left.val + pre.val + node.val == sum) {
                            num++;
                        } else if (node.left.val + node.val == sum) {
                            num++;
                        }
                        stack1.add(node.left);
                    }
                }
                stack = stack1;
                pre = peek;
            }
            return num;
        }

        private void printNode(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            left.add(root.val);
            right.add(root.val);
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
                if (node.right != null) {
                    stack.add(node.right);
                    right.add(node.right.val);
                }
                if (node.left != null) {
                    stack.add(node.left);
                    left.add(node.left.val);
                }
            }
        }

        private void print(List<Integer> list) {
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}