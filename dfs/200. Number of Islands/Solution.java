class Solution {
    public int numIslands(char[][] grid) {
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
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int r, int c){
        if(r>=grid.length || r<0 || c>=grid[0].length || c<0 || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public boolean check(int r, int c,int m, int n){
        if(r>=m || r<0 || c>=n || c<0){
            return false;
        }
        return true;
    }
}
