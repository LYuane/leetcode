//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 651 👎 0


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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode mid = generateMid(head);
        ListNode end = reverseList(mid);
        while(end != null){
            if(end.val != head.val){
                return false;
            }
            end = end.next;
            head = head.next;
        }
        return true;

    }

    //奇节点数：返回中间节点；偶节点数：返回右中位数节点。
    private ListNode generateMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null){
            ListNode last = curr.next;
            curr.next = pre;

            pre = curr;
            curr = last;
        }

        head.next = null;
        return pre;
    }
}
//
//import java.io.*;
//import java.util.List;
//import java.util.ArrayList;
//
//class Solution {
//    public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while(head != null){
//            list.add(head.val);
//            head = head.next;
//        }
//        int[] res = (int[])list.toArray(new int[list.size()]);
//        //list.toArray(res);
////        int[] res = new int[list.size()];
////        list.toArray(res);
//
//        for(int i = 0,j = res.length-1;i < j ; i++,j--){
//            if(res[i] != res[j]){
//                return false;
//            }
//        }
//        return true;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
