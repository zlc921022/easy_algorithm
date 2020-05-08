package leetcode.editor.cn;

//[21]合并两个有序链表
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


import org.junit.Test;

public class T21 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.add(2);
        l1.add(4);

        ListNode l2 = new ListNode(1);
        l2.add(3);
        l2.add(4);

        Solution s = new Solution();
        ListNode node = s.mergeTwoLists(l1, l2);
        System.out.println();
        printNode(node);
    }

    /**
     * 打印节点数据
     *
     * @param node node节点
     */
    private void printNode(ListNode node) {
        if (node != null) {
            while (node.next != null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println(node.val);
        }
    }

    class Solution {
        /**
         * 合并链表
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                }
                printNode(curr);
//                System.out.println("l1");
//                printNode(l1);
//                System.out.println("l2");
//                printNode(l2);
            }
            if (l1 != null) {
                curr.next = l1;
            }
            if (l2 != null) {
                curr.next = l2;
            }
            return dummyHead.next;
        }
    }


    class ListNode {
        private int val;
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
                this.next = pre;
            }
        }
    }
}