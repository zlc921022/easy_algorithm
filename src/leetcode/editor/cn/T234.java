package leetcode.editor.cn;

//[234]回文链表
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T234 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node = new ListNode(-1);
        node.add(2);
        node.add(2);
        node.add(-1);

        Solution s = new Solution();
        boolean palindrome = s.isPalindrome(node);
        System.out.println(palindrome);
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode curr = head;
            ListNode next = head;
            ListNode pre = head;
            while (curr != null) {
                while (next.next != null) {
                    pre = next;
                    next = next.next;
                }
                // 每次都判断最后一个节点的值和当前节点的值是否相等
                // 相等就把最后一个节点移除掉
                if (next.val == curr.val) {
                    pre.next = null;
                } else {
                    return false;
                }
                curr = curr.next;
                next = curr;
            }
            return true;
        }

        /**
         * 放入集合中 方便比较
         *
         * @param head
         * @return
         */
        public boolean isPalindrome2(ListNode head) {
            if (head == null) {
                return true;
            }
            List<Integer> list = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                list.add(curr.val);
                curr = curr.next;
            }

            int front = 0;
            int end = list.size() - 1;
            while (front < end) {
                if (!list.get(front).equals(list.get(end))) {
                    return false;
                }
                front++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}