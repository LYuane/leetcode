//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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
/* solution one:递归遍历
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        if(root.left != null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            inorderTraversal(root.right);
        }
        return list;
    }
}*/

class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList();
        }

        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode temp = root;

        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }

            temp = s.pop();
            res.add(temp.val);
            temp = temp.right;
        }

        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
