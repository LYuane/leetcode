//给定一个整数 n, 返回从 1 到 n 的字典顺序。 
//
// 例如， 
//
// 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。 
//
// 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。 
// Related Topics 深度优先搜索 字典树 
// 👍 181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> res;

    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i <10 ; i++) {
            dfs(n,i);
        }
        return res;
    }

    private void dfs(int n, int i){
        if(i < n){
            res.add(i);
        }else{
            return;
        }
        for (int j = 0; j < 10; j++) {
            dfs(n,i*10+j);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
