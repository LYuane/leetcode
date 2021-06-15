//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 662 👎 0


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
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null){
//            return  new ArrayList<>();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            List<Integer> tempList = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode temp = q.poll();
//                tempList.add(temp.val);
//                if(temp.left != null){
//                    q.offer(temp.left);
//                }
//                if(temp.right != null){
//                    q.offer(temp.right);
//                }
//            }
//            res.add(tempList);
//        }
//        return res;
//    }

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if(temp != null){
                    tempList.add(temp.val);
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            if(!tempList.isEmpty()){
                res.add(tempList);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
