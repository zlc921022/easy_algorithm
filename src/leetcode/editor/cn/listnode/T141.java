package leetcode.editor.cn.listnode;

//[141]环形链表
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针


import org.junit.Test;

import java.util.HashSet;

public class T141 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 哈希表算法
         * 通过检查一个结点此前是否被访问过来判断链表是否为环形链表
         *
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            HashSet<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return true;
                } else {
                    set.add(head);
                }
                head = head.next;
            }
            return false;
        }

        /**
         * 双指针方案
         * 想象一下，两名运动员以不同的速度在环形赛道上跑步会发生什么？ 结果肯定是快跑者后面会与慢跑者相遇的
         *
         * @param head
         * @return
         */
        public boolean hasCycle2(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}