//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 403 👎 0


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
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        int sign = pre.val;
        while(curr != null){
            if(curr.val == sign){
                curr = curr.next;
            }else{
                pre.next = curr;
                pre = curr;
                sign = pre.val;
                curr = curr.next;
            }
        }
        pre.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
