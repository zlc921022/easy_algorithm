package leetcode.editor.cn.链表;

//[876]链表的中间结点
//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = 
//NULL.
// 
//
// 示例 2： 
//
// 输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 给定链表的结点数介于 1 和 100 之间。 
// 
// Related Topics 链表


import leetcode.editor.cn.链表.ListNode;
import org.junit.Test;

public class T876 {

    public static void main(String[] args) {

    }


    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.add(2);
        node.add(3);
        node.add(4);
        Solution s = new Solution();
        node = s.middleNode2(node);
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
         * 传统方法 计算长度
         * @param head
         * @return
         */
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int size = 0;
            ListNode curr = head;
            while (curr != null) {
                size++;
                curr = curr.next;
            }
            ListNode temp = head;
            for (int i = 0; temp != null && i < size / 2; i++) {
                temp = temp.next;
            }
            return temp;
        }

        /**
         * 一个指针一次走1步 一个指针一次走2步 当走2步的指针走到末尾了 走一步的指针刚好走到中间
         *
         * @param head
         * @return
         */
        public ListNode middleNode2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curr = head;
            ListNode next = head;
            while (next != null && next.next != null) {
                curr = curr.next;
                next = next.next.next;
            }
            return curr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}