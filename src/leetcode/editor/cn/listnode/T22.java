package leetcode.editor.cn.listnode;

//[面试题22]链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针


import org.junit.Test;

public class T22 {

    public static void main(String[] args) {

    }
    
    @Test
    public void test(){
        ListNode node = new ListNode(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);

        Solution s = new Solution();
        node = s.getKthFromEnd(node, 3);
        ListNode.printNode(node);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return k ==1 ? head : null;
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
        return (k <= length && k > 0) ? kNode : null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}