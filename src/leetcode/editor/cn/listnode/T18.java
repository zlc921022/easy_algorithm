package leetcode.editor.cn.listnode;

//[面试题18]删除链表的节点
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表


import org.junit.Test;

public class T18 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(4);
        l1.add(5);
        l1.add(1);
        l1.add(9);
        l1.add(1);
        Solution s = new Solution();
        ListNode node = s.deleteNode(l1, 1);
        ListNode.printNode(node);
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
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head.val == val ? head : null;
            }
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                if (curr.val == val) {
                    if (pre == null) {
                        head = head.next;
                    } else {
                        pre.next = curr.next;
                        curr.next = null;
                    }
                    break;
                }
                pre = curr;
                curr = curr.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}