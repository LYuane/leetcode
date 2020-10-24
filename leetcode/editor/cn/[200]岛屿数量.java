//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 823 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class coordinate{
        int x;
        int y;
        public coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
//        bfs解法
        int m = grid.length;
        if( m < 0){
            return 0;
        }
        int n = grid[0].length;
        if( n < 0){
            return 0;
        }

        int res = 0;
        Queue<coordinate> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    res++;
                    q.offer(new coordinate(i,j));
                    while(!q.isEmpty()){
                        coordinate temp = q.remove();
                        if(temp.x - 1 >=0 && grid[temp.x-1][temp.y] == '1'){
                            q.offer(new coordinate(temp.x-1, temp.y));
                            grid[temp.x-1][temp.y] = '0';
                        }
                        if(temp.x+1 < m && grid[temp.x+1][temp.y] == '1'){
                            q.offer(new coordinate(temp.x+1, temp.y));
                            grid[temp.x+1][temp.y] = '0';
                        }
                        if(temp.y - 1 >= 0 && grid[temp.x][temp.y-1] == '1'){
                            q.offer(new coordinate(temp.x, temp.y-1));
                            grid[temp.x][temp.y-1] = '0';
                        }
                        if(temp.y + 1 < n && grid[temp.x][temp.y+1] == '1'){
                            q.offer(new coordinate(temp.x, temp.y+1));
                            grid[temp.x][temp.y+1] = '0';
                        }
                    }
                }
            }
        }
        return res;

//        int m = grid.length;
//        if( m < 0){
//            return 0;
//        }
//        int n = grid[0].length;
//        if( n < 0){
//            return 0;
//        }
//
//        int res = 0;
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(grid[i][j] == '1'){
//                    res++;
//                    dfs(grid,i,j);
//                }
//            }
//        }
//        return res;
//    }
//
//    private void dfs(char[][] grid, int i , int j ){
//        int m = grid.length;
//        int n = grid[0].length;
//
//        if(i < 0 || i >= m || j<0 || j >= n){
//            return;
//        }
//
//        if(grid[i][j] == '1'){
//            grid[i][j] = '0';
//            dfs(grid,i-1,j);
//            dfs(grid,i+1,j);
//            dfs(grid,i,j-1);
//            dfs(grid,i,j+1);
//        }else{
//            return;
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
