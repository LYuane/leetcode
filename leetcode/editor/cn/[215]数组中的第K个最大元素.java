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
//    public int findKthLargest(int[] nums, int k) {
//        return findKthLargest(nums,0,nums.length-1,k);
//    }
//    private int findKthLargest(int[] nums, int left, int right, int k){
//        if(left <= right){
//            int index = partition(nums,left,right);
//            if(index == nums.length-k){
//                return nums[index];
//            }else if(index > nums.length-k){
//                return findKthLargest(nums,left,index-1,k);
//            }else{
//                return findKthLargest(nums,index+1,right,k);
//            }
//        }
//        return -1;
//    }
//    private int partition(int[] nums,int left,int right){
//        int temp = nums[left];
//        while(left < right){
//            while(left < right && nums[right] >= temp){
//                right--;
//            }
//            swap(nums,left,right);
//            while(left < right && nums[left] <temp){
//                left++;
//            }
//            swap(nums,left,right);
//        }
//        nums[left] = temp;
//        return left;
//    }
//    private void swap(int[] nums, int left, int right){
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }


//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for(int item : nums){
//            queue.add(item);
//            if(queue.size() > k){
//                queue.poll();
//            }
//        }
//        return queue.poll();
//    }

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = nums.length-1; i >= nums.length-k+1; --i) {
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums,0,heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums,int heapSize){
        for (int i = heapSize/2; i >=0 ; i--) {
            maxHeapify(nums,i,heapSize);
        }
    }

    public void maxHeapify(int[] nums, int i, int heapSize){
        int l = i*2+1;
        int r = i*2+2;
        int largest = i;
        if(l < heapSize && nums[l] > largest){
            largest = l;
        }
        if(r < heapSize && nums[r] > largest){
            largest = r;
        }
        if(largest != i){
            swap(nums,i,largest);
            maxHeapify(nums,largest,heapSize);
        }
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
