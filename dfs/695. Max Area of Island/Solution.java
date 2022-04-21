class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        if(n == 0){
            return 0;
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int r, int c){
        if(!check(r,c,grid.length,grid[0].length)){
            return 0;
        }
        if(grid[r][c] == 0){
            return 0;
        }
        int res = grid[r][c];
        grid[r][c] = 0;
        res += dfs(grid,r-1,c);
        res += dfs(grid,r+1,c);
        res += dfs(grid,r,c-1);
        res += dfs(grid,r,c+1);
        return res;
    }

    public boolean check(int r, int c,int m, int n){
        if(r>=m || r<0 || c>=n || c<0){
            return false;
        }
        return true;
    }
}
