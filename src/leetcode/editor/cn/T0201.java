package leetcode.editor.cn;

//[面试题 02.01]移除重复节点
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表


import org.junit.Test;

import java.util.HashSet;

public class T0201 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.add(1);
        node.add(1);
        node.add(1);
        node.add(2);
        node.add(1);

        Solution s = new Solution();
        node = s.removeDuplicateNodes2(node);
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
    /**
     * 后面每一个元素和前面的元素进行比较
     * 冒泡排序思想
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curr = head;
            ListNode node;
            while (curr != null) {
                node = curr;
                while (node.next != null) {
                    if (curr.val == node.next.val) {
                        node.next = node.next.next;
                    } else {
                        node = node.next;
                    }
                }
                curr = curr.next;
            }
            return head;
        }

        public ListNode removeDuplicateNodes2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            HashSet<Integer> set = new HashSet<>();
            ListNode curr = head;
            ListNode pre = head;
            while (curr != null) {
                if (!set.contains(curr.val)) {
                    set.add(curr.val);
                    pre = curr;
                } else {
                    pre.next = curr.next;
                }
                curr = curr.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}