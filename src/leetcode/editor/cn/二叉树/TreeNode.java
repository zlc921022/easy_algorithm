package leetcode.editor.cn.二叉树;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;

    public TreeNode(Integer x) {
        this.val = x;
    }

    public TreeNode() {

    }

    public void add(Integer e) {
        root = add(root, e);
    }

    private TreeNode add(TreeNode node, Integer e) {
        if (node == null) {
            return new TreeNode(e);
        }
        if (e.compareTo(node.val) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.val) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public  void printTreeNode() {
        TreeNode node = root;
        printTree(node);
        System.out.println();
    }

    private  void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
