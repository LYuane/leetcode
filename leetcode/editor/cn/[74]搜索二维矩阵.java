//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m < 1 ){
            return false;
        }
        int n = matrix[0].length;
        if(n < 1 ){
            return false;
        }
        int pre = 0;
        int last = m-1;
        while(pre < last){
            int index = pre + (last - pre)/2;
            if(matrix[index][0] == target){
                return true;
            }else if (matrix[index][0] < target && matrix[index+1][0]>target){
                pre=index;
                break;
            }else if(matrix[index][0] > target){
                last = index-1;
            }else{
                pre = index+1;
            }
        }

        int i = 0;
        int j = n-1;
        while(i < j){
            int index = i+(j-i)/2;
            if(matrix[pre][index] == target){
                return true;
            }else if(matrix[pre][index] > target){
                j = index-1;
            }else{
                i = index+1;
            }
        }
        return matrix[pre][i] == target;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
