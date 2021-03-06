//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode dum = new ListNode();
//        dum.next = head;
//        ListNode pre = dum;
//        ListNode curr = head;
//        while(curr != null && curr.next != null){
//            ListNode last = curr.next;
//            pre.next = last;
//            curr.next = last.next;
//            last.next = curr;
//
//            pre = curr;
//            curr = curr.next;
//        }
//        return dum.next;
//
//    }
//}


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode();
        if(head == null || head.next == null){
            return head;
        }
        start.next = head;

        ListNode pre = start;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            ListNode last = curr.next;
            pre.next = last;
            curr.next = last.next;
            last.next = curr;

            pre = curr;
            curr = pre.next;
        }

        return start.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
