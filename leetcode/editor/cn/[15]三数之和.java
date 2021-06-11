//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3408 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        int start = 0;
        int end = nums.length -1;
        while (start < end){
            int flag = -1 * (nums[start]+nums[end]);
            if(map.containsKey(flag)){
                if(flag == 0 && nums[start] ==0 && nums[end] == 0 && map.get(flag) <= 2){
                    start++;
                    continue;
                }else if((flag == nums[start] || flag == nums[end]) && map.get(flag) < 2){
                    start++;
                    continue;
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(flag);
                temp.add(nums[start]);
                temp.add(nums[end]);
                res.add(temp);
                start++;
            }else {
                start++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
