package leetcode.editor.cn.listnode;

//[1290]二进制链表转整数
//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。 
//
// 请你返回该链表所表示数字的 十进制值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
// 
//
// 示例 2： 
//
// 输入：head = [0]
//输出：0
// 
//
// 示例 3： 
//
// 输入：head = [1]
//输出：1
// 
//
// 示例 4： 
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
// 
//
// 示例 5： 
//
// 输入：head = [0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 链表不为空。 
// 链表的结点总数不超过 30。 
// 每个结点的值不是 0 就是 1。 
// 
// Related Topics 位运算 链表


import org.junit.Test;

public class T1290 {

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.add(0);
        node.add(1);
//        node.add(1);
//        node.add(1);
//        node.add(1);
//        node.add(0);
        Solution s = new Solution();
        int value = s.getDecimalValue2(node);
        System.out.println(value);
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
         * 遍历两次
         *
         * @param head
         * @return
         */
        public int getDecimalValue(ListNode head) {
            ListNode curr = head;
            int length = 0;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            ListNode temp = head;
            int sum = 0;
            int i = length - 1;
            while (temp != null) {
                if (temp.val == 1) {
                    sum += temp.val * Math.pow(2, i);
                }
                temp = temp.next;
                i--;
            }
            return sum;
        }


        /**
         * 存到字符串里面 调用系统方法转
         *
         * @param head
         * @return
         */
        public int getDecimalValue1(ListNode head) {
            ListNode curr = head;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append(curr.val);
                curr = curr.next;
            }
            return Integer.parseInt(sb.toString(), 2);
        }

        /**
         * 位运算实现
         * @param head
         * @return
         */
        public int getDecimalValue2(ListNode head) {
            ListNode curr = head;
            int sum = 0;
            while (curr != null) {
                sum = (sum << 1) + curr.val;
                curr = curr.next;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}