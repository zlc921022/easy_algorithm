package leetcode.editor.cn;

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


import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T104 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        TreeNode treeNode = new TreeNode();
        treeNode.add(3);
        treeNode.add(2);
        treeNode.add(1);
        treeNode.add(4);
        treeNode.add(5);
        treeNode.add(6);

        Solution s = new Solution();
        int sum = s.maxDepth(treeNode.root);
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 求二叉数的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return sumDepth1(root);
    }

    /**
     * 递归 左右子树最大深度+1
     * @param root 根节点
     * @return
     */
    private int sumDepth1(TreeNode root){
        if(root == null){
            return 0;
        }
        int lDepth,rDepth;
        lDepth = sumDepth1(root.left);
        rDepth = sumDepth1(root.right);
        return Math.max(lDepth,rDepth) + 1;
    }

    /**
     * 非递归 通过队列遍历
     * @param root
     * @return
     */
    private int sumDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int sum = 0;
        while ( !deque.isEmpty()){
            Deque<TreeNode> deque1 = new LinkedList<>();
            while (!deque.isEmpty()){
                TreeNode node = deque.removeFirst();
                if(node.left != null){
                    deque1.add(node.left);
                    node.left = null;
                }
                if(node.right != null){
                    deque1.add(node.right);
                    node.right = null;
                }
            }
            deque = deque1;
            sum++;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}