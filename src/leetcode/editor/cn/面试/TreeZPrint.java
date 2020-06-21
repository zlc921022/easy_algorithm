package leetcode.editor.cn.面试;

import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author zlc
 * @created 2020/06/16
 */
public class TreeZPrint {

    @Test
    public void test() {
        TreeNode node = new TreeNode();
        node.add(5);
        node.add(3);
        node.add(1);
        node.add(4);
        node.add(7);
        node.add(6);
        node.add(9);
        node.add(8);
        node.add(10);
        printZTree(node.root);
    }

    public void printZTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int line = 1;
        // 奇数栈
        Stack<TreeNode> oddStack = new Stack<>();
        // 偶数栈
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.add(root);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (line % 2 == 1) {
                while (!oddStack.isEmpty()) {
                    TreeNode pop = oddStack.pop();
                    System.out.print(pop.val + " ");
                    if (pop.left != null) {
                        evenStack.push(pop.left);
                        pop.left = null;
                    }
                    if (pop.right != null) {
                        evenStack.push(pop.right);
                        pop.right = null;
                    }
                }
            } else {
                while (!evenStack.isEmpty()) {
                    TreeNode pop = evenStack.pop();
                    System.out.print(pop.val + " ");
                    if (pop.right != null) {
                        oddStack.push(pop.right);
                        pop.right = null;
                    }
                    if (pop.left != null) {
                        oddStack.push(pop.left);
                        pop.left = null;
                    }
                }
            }
            line++;
        }
    }
}
