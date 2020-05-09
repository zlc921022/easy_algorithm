package leetcode.editor.cn;

class ListNode {
    public int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public void add(int val) {
        if (this.next == null) {
            this.next = new ListNode(val);
        } else {
            ListNode pre = this.next;
            pre.next = new ListNode(val);
          //  this.next = pre;
        }
    }

   
}