package leetcode.editor.cn;

//[面试题 02.02]返回倒数第 k 个节点
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针


import org.junit.Test;

public class T0202 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        Solution s = new Solution();
        int value = s.kthToLast2(node, 5);
        System.out.println(value);
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
        /**
         * 获取长度 然后遍历获取倒数第k个数据
         * @param head
         * @param k
         * @return
         */
        public int kthToLast(ListNode head, int k) {
            if (head == null) {
                return -1;
            }
            if (head.next == null) {
                if (head.val == k) {
                    return head.val;
                }
            }
            ListNode curr = head;
            int length = 0;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            ListNode temp = head;
            for (int i = 0; i < length - k; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        /**
         * 思路：维护两个指针 倒数第2个 就是第二个指针晚两步再走 倒数第几个就晚几步走
         * @param head 头节点
         * @param k 倒数第几个数
         * @return
         */
        public int kthToLast2(ListNode head, int k) {
            if (head == null) {
                return -1;
            }
            if (head.next == null) {
                if (head.val == k) {
                    return head.val;
                }
            }
            ListNode curr = head;
            ListNode kNode = head;
            int temp = 0;
            int length = 0;
            while (curr != null) {
                if (temp >= k) {
                    kNode = kNode.next;
                }
                temp++;
                length++;
                curr = curr.next;
            }
            ListNode.printNode(head);
            return (k <= length && k > 0) ? kNode.val : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}