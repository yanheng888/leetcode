class Solution {
    int m,n;
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new int[m][n];
        return dfs(0,0);

    }
        public int dfs(int x, int y) {
            if(!checkIndex(x,y)) return 0; // 越界
            if(x == m-1 && y == n-1) return 1; // 终点
            if(memo[x][y] != 0){
                return memo[x][y];
            }
            int res = dfs(x + 1, y) + dfs(x, y + 1);
            memo[x][y] = res;

            return res;
    }
    public boolean checkIndex(int r,int c){
        if(r<0 || r >=m || c<0 || c>=n){
            return false;
        }
        return true;
    }
}
