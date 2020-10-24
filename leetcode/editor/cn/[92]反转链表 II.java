//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 551 👎 0


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
         ListNode startNode = new ListNode();
         startNode.next = head;
         int count = 0;
         ListNode curr = startNode;
         ListNode pre;
         ListNode last;
         ListNode start;
         ListNode end;
         while(count != m-1){
             count++;
             curr = curr.next;
         }
         pre = curr;
         start = pre.next;
         curr = curr.next;
         count++;
         while (count != n-1){
             ListNode next = curr.next;
             ListNode last = next.next;
             next.next = curr;

         }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
