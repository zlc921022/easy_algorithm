package leetcode.editor.cn.链表;

//[面试题 02.07]链表相交
//给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个
//节点是同一节点（引用完全相同），则这两个链表相交。 示例 1： 输入：intersectVal = 8, listA = [4,1,8,4,5], listB 
//= [5,0,1,8,4,5], skipA = 2, skipB = 3 输出：Reference of the node with value = 8 输入
//解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4
//,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。 示例 2： 输入：intersectVal = 2, listA = [0
//,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 输出：Reference of the node with v
//alue = 2 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为
// [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。 示例 3： 输入：intersectVal = 0, listA
// = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 输出：null 输入解释：从各自的表头开始算起，链表 A 为 [
//2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。 解释：
//这两个链表不相交，因此返回 null。 注意： 如果两个链表没有交点，返回 null 。 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循
//环。 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 Related Topics 链表


import leetcode.editor.cn.链表.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class T0207 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(3);


        ListNode node2 = new ListNode(3);
        node2.add(2);
        node2.add(1);
        node2.add(0);

        Solution s = new Solution();
        s.getIntersectionNode(node1, node2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
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
         * 消除长度差，最终两个指针要么相遇，要么都是空
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while (nodeA != nodeB) {
                nodeA = nodeA == null ? headB : nodeA.next;
                nodeB = nodeB == null ? headA : nodeB.next;
            }
            return nodeA;
        }

        /**
         * 哈希表算法
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            ListNode curr = headA;
            while (curr != null) {
                set.add(curr);
                curr = curr.next;
            }
            ListNode nodeB = headB;
            while (nodeB != null) {
                if (set.contains(nodeB)) {
                    return nodeB;
                }
                nodeB = nodeB.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}