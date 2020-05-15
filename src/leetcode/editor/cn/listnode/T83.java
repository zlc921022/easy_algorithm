package leetcode.editor.cn.listnode;

//[83]删除排序链表中的重复元素
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


import org.junit.Test;

public class T83 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.add(1);
        node.add(1);
        node.add(2);
        node.add(2);
        node.add(3);
        node.add(3);

        Solution s = new Solution();
        ListNode newnode = s.deleteDuplicates(node);
        System.out.println();
        ListNode.printNode(newnode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curr = head;
            while (curr.next != null) {
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
        }

        public ListNode deleteDuplicates2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            head.next = deleteDuplicates2(head.next);
            if (head.val == head.next.val) {
                head = head.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}