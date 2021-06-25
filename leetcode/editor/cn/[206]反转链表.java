//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1251 👎 0


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
    // 迭代
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        ListNode pre = head;
//        ListNode curr = head.next;
//        while(curr != null){
//            ListNode last = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = last;
//        }
//        head.next = null;
//        return pre;
//    }

    //递归
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null) return head;
//        ListNode p = reverseList(head.next);
//        ListNode last = head.next;
//        last.next = head;
//        head.next = null;
//        return p;
//
//    }




    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        ListNode last = head.next;
        last.next = head;
        head.next = null;
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
