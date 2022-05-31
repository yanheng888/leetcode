class Solution {
    int[][] memo;
    int[][] dirs;
    int[][] mat;
    int res = 0;
    public int longestIncreasingPath(int[][] mat) {
        dirs = new int[4][2];
        this.mat = mat;
        dirs[0] = new int[]{-1,0};
        dirs[1] = new int[]{1,0};
        dirs[2] = new int[]{0,-1};
        dirs[3] = new int[]{0,1};
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i,j,1);
            }
        }
        return res;
    }
    private boolean isOk(int i, int j){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length){
            return false;
        }
        return true;
    }
    private void dfs(int i, int j, int step) {
        if(!isOk(i,j)){
            return;
        }
        res = Math.max(res,step);
        for(int[] dir:dirs){
            int x = i+dir[0], y = j+dir[1];
            if(!isOk(x,y)){
                continue;
            }
            int next = mat[x][y];
            int cur = mat[i][j];
            if(cur < next){
                dfs(x,y,step+1);
            }
        }
    }
}
