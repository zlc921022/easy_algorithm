package leetcode.editor.cn.review.链表;

import leetcode.editor.cn.链表.ListNode;

import java.util.HashSet;

/**
 * @author zlc
 * @created 2020/06/21
 */
public class ListNodeTest {


    @org.junit.Test
    public void test1() {
        ListNode node = new ListNode(5);
        node.add(4);
        node.add(2);
        node.add(6);
        node.add(8);
        node.add(7);
        ListNode reverse = reverse(node);
        ListNode.printNode(reverse);
    }


    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeNode(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode = new ListNode(0);
        ListNode curr = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return newNode.next;
    }


    /**
     * 删除链表节点
     *
     * @param head
     * @param val
     * @return
     */
    private ListNode delNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null && head.val == val) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        ListNode pre = dummyHead;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

    /**
     * 环形列表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            } else {
                set.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }


    /**
     * 环形列表
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }

    /**
     * 回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverse(slow);
        ListNode curr = head;
        while (reverse != null) {
            if (reverse.val != curr.val) {
                return false;
            }
            curr = curr.next;
            reverse = reverse.next;
        }
        ListNode.printNode(slow);
        return true;
    }

    /**
     * 倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int i = 0;
        ListNode curr = head;
        ListNode slow = head;
        while (curr != null) {
            i++;
            if (i > k) {
                slow = slow.next;
            }
            curr = curr.next;
        }
        return slow;
    }
}
