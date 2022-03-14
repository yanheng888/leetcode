class Solution {
    int res = 0;
    int m,n;
    int[][] dirs = new int[4][2];
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        dirs[0] = new int[]{1,0};
        dirs[1] = new int[]{-1,0};
        dirs[2] = new int[]{0,1};
        dirs[3] = new int[]{0,-1};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res,dfs(i,j,1,matrix));
            }
        }
        return res;
    }
    private boolean isOk(int r, int c){
        return !(r<0 || r>=m || c<0 || c>=n);
    }
    private int dfs(int r, int c, int step,int[][] mat) {
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        ++dp[r][c];
        for(int[] dir: dirs){
            int x = r+dir[0], y = c+dir[1];
            if(!isOk(x,y)){
                continue;
            }
            int cur = mat[r][c];
            int next = mat[x][y];
            if(cur < next){
                dp[r][c] = Math.max(dp[r][c],1+dfs(x,y,step+1,mat));
            }
        }
        return dp[r][c];
    }
}
