package leetcode.editor.cn;

class ListNode {
    public int val;
    ListNode next;
    ListNode node;

    ListNode(int val) {
        this.val = val;
        this.node = this;
    }

    ListNode() {
        this.node = this;
    }

    public void add(int val) {
        node.next = new ListNode(val);
        node = node.next;
    }

    /**
     * 打印节点数据
     *
     * @param node node节点
     */
    public static void printNode(ListNode node) {
        if (node != null) {
            while (node != null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println("NULL");
        }
    }

}