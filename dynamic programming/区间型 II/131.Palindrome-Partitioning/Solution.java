import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    int n;
    List<List<String>> res = new LinkedList<>();
    String s;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        this.n = s.length();
        this.s = s;
        this.dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n-1; i >= 0; --i) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
            }
        }
        LinkedList<String> temp = new LinkedList<>();
        dfs(0,temp);
        return res;
    }

    private void dfs(int i, LinkedList<String> temp) {
        if(i == n){
            res.add(new LinkedList<String>(temp));
            return;
        }
        for (int j = i; j < n; j++) {
            if(dp[i][j]){
                temp.add(s.substring(i,j+1));
                dfs(j+1,temp);
                temp.pollLast();
            }
        }
    }
}
