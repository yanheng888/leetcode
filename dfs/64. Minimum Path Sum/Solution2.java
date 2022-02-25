class Solution {
    int[][] grid;
    int m,n;
    int res;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        if(m == 0){
            return 0;
        }
        n = grid[0].length;
        this.grid = grid;
        res = Integer.MAX_VALUE;
        dfs(0,0,0);
        return res;
    }

    public void dfs(int i, int j, int x){
        if(i >= m || j >= n || x >= res){
            return;
        }
        x += grid[i][j];
        if(i == m-1 && j == n-1){
            res = Math.min(res, x);
            return;
        }
        dfs(i+1,j,x);
        dfs(i,j+1,x);
    }
}
