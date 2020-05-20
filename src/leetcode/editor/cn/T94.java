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

import java.util.*;

public class T94 {

    public static void main(String[] args) {

    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode();
        treeNode.add(3);
        treeNode.add(2);
        treeNode.add(1);
        treeNode.add(4);

//        TreeNode.printTreeNode();
        Solution s = new Solution();
        List<Integer> list = s.levelOrderTraversal(treeNode.root);
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

        public List<Integer> preorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            return preOrderNR(root);
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            return inOrderNR(root);
        }

        public List<Integer> afterOrderTraversal(TreeNode root) {
            list = new ArrayList<>();
            return afterOrderTraversal(root);
        }

        public List<Integer> levelOrderTraversal(TreeNode root){
            list = new ArrayList<>();
            return levelOrder(root);
        }

        /**
         * 前序遍历 先根节点-->左节点-->右节点
         *
         * @param root 根节点
         */
        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

        /**
         * 中序遍历 先左节点-->根节点-->右节点
         *
         * @param root 根节点
         */
        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }

        /**
         * 后序遍历 先左节点-->右节点-->根节点
         *
         * @param root 根节点
         */
        private void afterOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            afterOrder(root.left);
            afterOrder(root.right);
            list.add(root.val);
        }


        /**
         * 前序遍历遍历形式非递归 先根节点-->左节点-->右节点
         * 画图理解快
         *
         * @param root 根节点
         */
        private List<Integer> preOrderNR(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            stack.push(root);
            list.add(root.val);
            while (!stack.isEmpty()) {
                // 取出栈顶元素 但是不删除 pop是取出和删除
                TreeNode node = stack.peek();
                if (node.left != null) {
                    stack.push(node.left);
                    list.add(node.left.val);
                    node.left = null;
                    continue;
                }
                if (node.right != null) {
                    stack.push(node.right);
                    list.add(node.right.val);
                    node.right = null;
                    continue;
                }
                stack.pop();
            }
            return list;
        }

        /**
         * 中序遍历遍历形式非递归 先左节点-->根节点-->右节点
         * 画图理解快
         *
         * @param root 根节点
         */
        private List<Integer> inOrderNR(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                // 取出栈顶元素 但是不删除 pop是取出和删除
                TreeNode node = stack.peek();
                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                    continue;
                }
                list.add(node.val);
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
            }
            return list;
        }

        /**
         * 后序遍历遍历形式非递归 先左节点-->右节点-->根节点
         * 画图理解快
         *
         * @param root 根节点
         */
        private List<Integer> afterOrderNR(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                // 取出栈顶元素 但是不删除 pop是取出和删除
                TreeNode node = stack.peek();
                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                    continue;
                }
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                    continue;
                }
                list.add(node.val);
                stack.pop();
            }
            return list;
        }

        /**
         * 层序遍历
         *
         * @param root 根节点
         */
        private List<Integer> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.push(root);
            list.add(root.val);
            while (!deque.isEmpty()) {
                TreeNode node = deque.peekLast();
                if (node.left != null) {
                    list.add(node.left.val);
                    deque.push(node.left);
                    node.left = null;
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    deque.push(node.right);
                    node.right = null;
                }
                deque.pollLast();
            }
            return list;
        }


        /**
         * 层序遍历
         *
         * @param root 根节点
         */
        private List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.push(root);
            while (!deque.isEmpty()){
                List<Integer> list = new ArrayList<>();
                Deque<TreeNode> deque1 = new LinkedList<>();
                // 遍历每一层
                while ( !deque.isEmpty()){
                    TreeNode node = deque.removeFirst();
                    if(node.left != null){
                        deque1.add(node.left);
                        node.left = null;
                    }
                    if(node.right != null){
                        deque1.add(node.right);
                        node.right = null;
                    }
                    list.add(node.val);
                }
                deque = deque1;
                lists.add(0,list);
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}