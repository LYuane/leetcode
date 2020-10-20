//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 384 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }                pre.next = curr;
 *                 temp = curr.val;
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode start = new ListNode();
        start.next = head;

        ListNode pre = start;
        int temp = head.val;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.val == temp){
                while(curr != null && curr.val == temp){
                    curr = curr.next;
                }
                if(curr == null){
                    pre.next = null;
                    break;
                }else{
                    pre.next = curr;
                    temp = curr.val;
                    curr =curr.next;
                }
            }else{
                pre = pre.next;
                temp = curr.val;
                curr = curr.next;
            }

        }
        return start.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
