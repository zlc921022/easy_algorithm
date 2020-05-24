package leetcode.editor.cn.链表;

//[面试题 02.03]删除中间节点
//实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。 
//
// 
//
// 示例： 
//
// 
//输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
// 
// Related Topics 链表


import leetcode.editor.cn.链表.ListNode;
import org.junit.Test;

public class T0203 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node = new ListNode(4);
        node.add(5);
        node.add(1);
        node.add(9);

        Solution s = new Solution();
        s.deleteNode(node);
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
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null) {
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}