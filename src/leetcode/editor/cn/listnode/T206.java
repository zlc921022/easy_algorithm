package leetcode.editor.cn.listnode;

//[206]反转链表
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


import org.junit.Test;

public class T206 {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.add(2);
        node.add(3);

        System.out.println("反转前");
        ListNode.printNode(node);

        Solution s = new Solution();
        node = s.reverseList2(node);
        System.out.println("反转后");
        ListNode.printNode(node);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}