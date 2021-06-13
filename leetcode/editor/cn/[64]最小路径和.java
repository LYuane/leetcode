//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 686 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        for(int i = 1; i < m; i++){
//            grid[i][0] += grid[i-1][0];
//        }
//        for(int i = 1; i < n; i++){
//            grid[0][i] += grid[0][i-1];
//        }
//
//        for(int i = 1;i < m;i++){
//            for (int j = 1; j < n; j++) {
//                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
//            }
//        }
//
//        return grid[m-1][n-1];
//    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = m-2; i >= 0; i--) {
            grid[i][n-1] += grid[i+1][n-1];
        }
        for(int i = n-2; i >=0; i--){
            grid[m-1][i] += grid[m-1][i+1];
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                grid[i][j] += Math.min(grid[i][j+1],grid[i+1][j]);
            }
        }
        return grid[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
