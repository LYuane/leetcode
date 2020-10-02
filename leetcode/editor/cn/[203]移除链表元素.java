//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 452 👎 0


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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode start = new ListNode();
        start.next = head;

        ListNode pre = start;
        ListNode curr = head;

        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
            }else{
                pre = curr;
            }
            curr = curr.next;
        }
        return start.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
