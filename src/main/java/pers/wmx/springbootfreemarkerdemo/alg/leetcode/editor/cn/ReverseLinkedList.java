package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2291 👎 0


public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 需要记录next值
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

//    public ListNode reverseList(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode pre = null;
//        ListNode next = null;
//        ListNode cur = head;
//
//        while (cur.next != null) {
//            // 先拿到当前节点的下一节点，不然后面的链表就断掉了
//            next = cur.next;
//
//            cur.next = pre;
//            cur = next;
//            pre = cur;
//        }
//
//        cur.next = pre;
//        return cur;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

