//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length -1;
        int target = nums.length - k;
        while(true){
            int index = partition(nums,left,right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }

        /*优先队列：小顶堆  时间复杂度 NlogK
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num:nums){
            q.add(num);
            if(q.size()> k){
                q.poll();
            }
        }
        return q.poll();
        */

        /*排序  NlogN
        Arrays.sort(nums);
        return  nums[nums.length-k];
        */

    }

    private int partition(int[] nums, int left , int right){
        //int index = left;
        int pivot = nums[left];
        int i = left ;
        int j = right;
        while(i < j){
            while(i < j && nums[j] > pivot){
                j--;
            }
            swap(nums,i,j);
            while(i < j && nums[i] <= pivot){
                i++;
            }
            swap(nums,i,j);
        }
        return i;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
