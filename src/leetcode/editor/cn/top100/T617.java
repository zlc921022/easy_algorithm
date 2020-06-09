package leetcode.editor.cn.top100;

//[617]合并二叉树
//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树


import leetcode.editor.cn.二叉树.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class T617 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode();
        t1.add(1);
        t1.add(3);
        t1.add(2);
        t1.add(5);

        TreeNode t2 = new TreeNode();
        t1.add(2);
        t1.add(1);
        t1.add(3);
        t1.add(4);
        t1.add(7);

        Solution s = new Solution();
        TreeNode node = s.mergeTrees(t1.root, t2.root);
        node.printTreeNode();
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


        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }

        public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            Stack<TreeNode[]> stack = new Stack<>();
            stack.push(new TreeNode[]{t1, t2});
            while (!stack.isEmpty()) {
                TreeNode[] pop = stack.pop();
                if (pop[0] == null || pop[1] == null) {
                    continue;
                }
                pop[0].val += pop[1].val;
                if (pop[0].right == null) {
                    pop[0].right = pop[1].right;
                } else {
                    stack.push(new TreeNode[]{pop[0].right, pop[1].right});
                }
                if (pop[0].left == null) {
                    pop[0].left = pop[1].left;
                } else {
                    stack.push(new TreeNode[]{pop[0].left, pop[1].left});
                }
            }
            return t1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}