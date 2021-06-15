//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1060 👎 0


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

    //递归
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        return isSymmetric(root.left,root.right);
//    }
//
//    private boolean isSymmetric(TreeNode root1, TreeNode root2){
//        if(root1 == null && root2 == null){
//            return true;
//        }
//        if(root1 == null || root2 == null){
//            return false;
//        }
//        return (root1.val == root2.val) && isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
//    }

    //迭代
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null){
                continue;
            }
            if(t1 == null || t2 == null || t1.val != t2.val){
                return false;
            }
            q.offer(t1.left);
            q.offer(t2.right);
            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
