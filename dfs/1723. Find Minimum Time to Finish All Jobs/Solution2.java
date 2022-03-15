import java.util.HashMap;

class Solution {
    int[] time;
    int[][] memo;
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[][] dp = new int[k+1][1<<n];
        time = new int[1<<n];
        for (int state = 0; state < (1<<n); state++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(((state >> j)&1) == 1){
                    sum += jobs[j];
                }
            }
            time[state] = sum;
        }
        int low = 0,high = 0;
        for (int i = 0; i < n; i++) {
            high += jobs[i];
            low = Math.max(low,jobs[i]);
        }
        memo = new int[1<<n][k+1];
        while (low < high){
            int mid = low+(high-low)/2;
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < k+1; j++) {
                    memo[i][j] = 0;
                }
            }
            if(dfs((1<<n)-1,mid,k)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean dfs(int state, int mid, int k) {
        if(state == 0){
            return true;
        }
        if(k == 0){
            return false;
        }
        if(memo[state][k] == 1){
            return false;
        }
        if(memo[state][k] == 2){
            return true;
        }
        int temp = Integer.MAX_VALUE;
        for (int subset = state; subset > 0; subset=(subset-1)&state) {
            if(time[subset] > mid){
                continue;
            }
            if(dfs(state-subset,mid,k-1)){
                memo[state][k] = 2;
                return true;
            }
        }
        memo[state][k] = 1;
        return false;
    }
}
