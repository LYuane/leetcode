//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//    int k;
//    int res;
//    public int kthLargest(TreeNode root, int k){
//        this.k = k;
//        dfs(root);
//        return res;
//    }
//    private void dfs(TreeNode root){
//        if(root == null){
//            return;
//        }
//        dfs(root.right);
//        if(k == 1){
//            res = root.val;
//        }
//        k--;
//        dfs(root.left);
//    }

    public int kthLargest(TreeNode root, int k){
        Deque<TreeNode> deque = new LinkedList<>();

        while(!deque.isEmpty() || root != null){
            while(root != null){
                deque.push(root);
                root = root.right;
            }
            root = deque.pop();
            if(k == 1){
                return root.val;
            }else{
                k--;
            }
            root = root.left;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
