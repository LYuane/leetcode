//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 200 👎 0


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
//    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return res;
//        for (int i = 1; i < list.size(); i++) {
//            int temp = list.get(i) -list.get(i-1);
//            res = Math.min(res,temp);
//        }
//        return res;
    }

    private void inOrderTraversal(TreeNode root){
        if(root.left != null){
            inOrderTraversal(root.left);
        }
        if(pre != null){
            res = Math.min(res,root.val - pre.val);
        }
        pre = root;
//        list.add(root.val);

        if(root.right != null){
            inOrderTraversal(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
