//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2){
        if(l1 > r1){
            return null;
        }
        if(l1 == r1){
            return new TreeNode(preorder[l1]);
        }

        int num = preorder[l1];
        int index = findIndex(inorder,l2,r2,num);

        TreeNode res = new TreeNode(num);
        res.left = buildTree(preorder,inorder,l1+1,index-l2+l1,l2,index-1);
        res.right = buildTree(preorder,inorder,index-l2+l1+1,r1,index+1,r2);
        return res;
    }

    private int findIndex(int[] inorder, int l, int r, int num){
        for(int i = l; i <= r; i++){
            if(inorder[i] == num){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
