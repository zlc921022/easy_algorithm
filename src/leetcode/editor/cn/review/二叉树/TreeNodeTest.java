package leetcode.editor.cn.review.二叉树;

import leetcode.editor.cn.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zlc
 * @created 2020/06/14
 */
public class TreeNodeTest {

    /**
     * 5
     * 4 6
     * 2   8
     * 7
     */
    @org.junit.Test
    public void test1() {
        /**
         *    4
         *   2
         * 1  3
         */
        TreeNode node = new TreeNode();
        node.add(5);
        node.add(2);
        node.add(13);
        node.add(14);
        TreeNode node1 = convertBSTNR(node.root);
        node1.printTreeNode();

//        TreeNode node1 = new TreeNode();
//        node1.add(4);
//        node1.add(2);
//        node1.add(1);
//        node1.add(3);
//        TreeNode node2 = mergeTrees(node.root, node1.root);
//        node2.printTreeNode();
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


    /**
     * 前序遍历 非递归
     *
     * @param root
     */
    private void preOrderNR(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
    }

    /**
     * 前序遍历 非递归
     *
     * @param root
     */
    private void preOrderNR1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        System.out.print(root.val + " ");
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null) {
                System.out.print(peek.left.val + " ");
                stack.add(peek.left);
                peek.left = null;
                continue;
            }
            if (peek.right != null) {
                System.out.print(peek.right.val + " ");
                stack.add(peek.right);
                peek.right = null;
                continue;
            }
            stack.pop();
        }
    }

    /**
     * 中序遍历 非递归
     *
     * @param root
     */
    private void inOrderNR(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null) {
                stack.add(peek.left);
                peek.left = null;
                continue;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (peek.right != null) {
                stack.add(peek.right);
                peek.right = null;
            }
        }
    }

    /**
     * 后序遍历非递归
     *
     * @param root
     */
    private void postOrderNR(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null) {
                stack.add(peek.left);
                peek.left = null;
                continue;
            }
            if (peek.right != null) {
                stack.add(peek.right);
                peek.right = null;
                continue;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
        }
    }

    /**
     * 5
     * 4 6
     * 2   8
     * 7
     * 层序遍历
     */
    private void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(node);
        while (!deque.isEmpty()) {
            TreeNode first = deque.removeFirst();
            System.out.print(first.val + " ");
            if (first.left != null) {
                deque.add(first.left);
                first.left = null;
            }
            if (first.right != null) {
                deque.add(first.right);
                first.right = null;
            }
        }
    }

    /**
     * 最大深度 递归
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }


    /**
     * 最大深度 非递归
     * 5
     * 4  6
     * 2    8
     * 7
     *
     * @param root
     * @return
     */
    private int maxDepthNR(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int maxDepth = 0;
        while (!deque.isEmpty()) {
            Deque<TreeNode> deque1 = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque1.add(node.left);
                    node.left = null;
                }
                if (node.right != null) {
                    deque1.add(node.right);
                    node.right = null;
                }
            }
            maxDepth++;
            deque = deque1;
        }
        return maxDepth;
    }

    /**
     * 最小深度 递归
     * 5
     * 4  6
     * 2    8
     * 7
     *
     * @param root
     * @return
     */
    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }


    /**
     * 最小深度 非递归
     * 5
     * 4  6
     * 2    8
     * 7
     *
     * @param root
     * @return
     */
    private int minDepthNR(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        if (root.left == null && root.right == null) {
            return minDepth;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        w:
        while (!deque.isEmpty()) {
            Deque<TreeNode> deque1 = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.removeFirst();
                if (node.left == null && node.right == null) {
                    break w;
                }
                if (node.left != null) {
                    deque1.add(node.left);
                    node.left = null;
                }
                if (node.right != null) {
                    deque1.add(node.right);
                    node.right = null;
                }
            }
            minDepth++;
            deque = deque1;
        }
        return minDepth;
    }

    /**
     * 递归
     * 翻转一棵二叉树
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6  9
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }


    /**
     * 非递归
     * 翻转一棵二叉树
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6  9
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeNR(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
                deque.add(node.right);
            }
            if (node.left != null) {
                deque.add(node.left);
            }
        }
        return root;
    }

    /**
     * 递归
     * 合并二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
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


    /**
     * 非递归
     * 合并二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTreesNR(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.add(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode lNode = nodes[0];
            TreeNode rNode = nodes[1];
            if (lNode == null || rNode == null) {
                continue;
            }
            lNode.val += rNode.val;
            if (lNode.right == null) {
                lNode.right = rNode.right;
            } else {
                stack.add(new TreeNode[]{lNode.right, rNode.right});
            }

            if (lNode.left == null) {
                lNode.left = rNode.left;
            } else {
                stack.add(new TreeNode[]{lNode.left, rNode.left});
            }

        }
        return t1;
    }


    int num;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += num;
        num = root.val;
        convertBST(root.left);
        return root;
    }


    /**
     * 5
     * 2  13
     * 14
     */
    public TreeNode convertBSTNR(TreeNode root) {
        if (root == null) {
            return null;
        }
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     *
     * @param root
     * @param sum
     * @return 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


    /**
     * 路径总和 III
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * <p>
     * 找出路径和等于给定数值的路径总数。
     * <p>
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    private int pathSum(TreeNode root, int sum, int[] arr, int p) {
        if (root == null) {
            return 0;
        }
        int temp = root.val;
        int n = sum == root.val ? 1 : 0;
        if (p >= 1) {
            for (int i = p - 1; i >= 0; i--) {
                temp += arr[i];
                if (temp == sum) {
                    n++;
                }
            }
        }
        arr[p] = root.val;
        int l = pathSum(root.left, sum, arr, p + 1);
        int r = pathSum(root.right, sum, arr, p + 1);
        return n + l + r;
    }

}