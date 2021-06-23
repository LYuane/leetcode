//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right){
        if(left < right){
            int index = partition(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
    }

    private int partition(int[] nums, int left, int right){
        int temp = nums[left];
        while(left < right){
            while(left< right && nums[right] >= temp){
                right--;
            }
            swap(nums,left,right);
            while(left< right && nums[left] < temp){
                left++;
            }
            swap(nums,left,right);
        }

        nums[left] = temp;
        return left;
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
