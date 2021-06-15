//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


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

    //1.递归
//    public boolean isValidBST(TreeNode root){
//        if(root == null){
//            return true;
//        }
//        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
//    }
//
//    private boolean isValidBST(TreeNode root,long min,long max){
//        if(root == null){
//            return true;
//        }
//        if(root.val <= min || root.val >= max){
//            return false;
//        }
//        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
//    }


    //2.中序遍历为递增序列，用栈非递归
    public boolean isValidBST(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        long min = Long.MIN_VALUE;

        while(root != null || !deque.isEmpty()){
            while(root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if(root.val <= min){
                return false;
            }
            min = root.val;
            root = root.right;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
