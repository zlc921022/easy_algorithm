package leetcode.editor.cn;

//[94]二叉树的中序遍历
//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94 {

    public static void main(String[] args) {

    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode();
        treeNode.add(1);
        treeNode.add(2);
        treeNode.add(3);

        Solution s = new Solution();
        List<Integer> list = s.inorderTraversal(treeNode);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
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
        public List<Integer> inorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            inorder1(root);
            return list;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        private List<Integer> inorder1(TreeNode root){
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if(root == null){
                return list;
            }
            stack.add(root);
            while ( !stack.isEmpty()) {
                TreeNode node = stack.peek();
                if(node.left != null){
                    stack.push(node.left);
                    node.left = null;
                    continue;
                }
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if(node.right != null){
                    stack.push(node.right);
                }
            }
            return list;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}