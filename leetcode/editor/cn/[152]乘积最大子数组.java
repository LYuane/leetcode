//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 778 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
//        int len = nums.length;
//        if(len < 2){
//            return nums[0];
//        }
//        int[][] dp = new int[2][len];
//
//        dp[0][0] = nums[0]>0?nums[0]:0;
//        dp[1][0] = nums[0]>0?0:nums[0];
//
//        for (int i = 1; i < len; i++) {
//            dp[0][i] = Math.max(nums[i],nums[i]>0?(dp[0][i-1]*nums[i]):(dp[1][i-1]*nums[i]));
//            dp[1][i] = Math.min(nums[i],nums[i]>0?(dp[1][i-1]*nums[i]):(dp[0][i-1]*nums[i]));
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < len; i++) {
//            max = max>dp[0][i]?max:dp[0][i];
//        }
//        return max;

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int imax = max;
            int imin = min;
            max = Math.max(nums[i],Math.max(nums[i]*imax,nums[i]*imin));
            min = Math.min(nums[i],Math.min  (nums[i]*imax,nums[i]*imin));
            res = Math.max(max,res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
