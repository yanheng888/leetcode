import java.util.Arrays;

class Solution {
    int[] temp1 = new int[3];
    int[] temp2 = new int[3];
    int M = 1000000007;
    public int numOfWays(int n) {
        int[] dp = new int[27];
        boolean[] x = new boolean[27];
        boolean[][] y = new boolean[27][27];
        for (int i = 0; i < 27; i++) {
            if(selfOk(i)){
                dp[i] = 1;
                x[i] = true;
            }
            for (int j = 0; j < 27; j++) {
                if(crossOk(i,j)){
                    y[i][j] = true;
                }
            }
        }
        Arrays.fill(temp1,0);
        Arrays.fill(temp2,0);
        for (int i = 1; i < n; i++) {
            int[] pre = Arrays.copyOf(dp,dp.length);
            for (int j = 0; j < 27; j++) {
                dp[j] = 0;
                if(!x[j]){
                    continue;
                }
                for (int k = 0; k < 27; k++) {
                    if(!x[k]){
                        continue;
                    }
                    if(y[j][k]){
                        dp[j] = (dp[j]% M + pre[k]% M) % M;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 27; i++) {
            if(selfOk(i)){
                res = (res+dp[i]% M) % M;
            }
        }
        return (res% M);
    }

    public boolean selfOk(int p){
        for (int i = 0; i < 3; i++) {
            temp1[i] = p%3;
            p /= 3;
        }
        return (temp1[0] != temp1[1]) && (temp1[1] != temp1[2]);
    }

    public boolean crossOk(int p,int q){
        for (int i = 0; i < 3; i++) {
            temp1[i] = p%3;
            temp2[i] = q%3;
            p /= 3;
            q /= 3;
        }
        return (temp1[0] != temp2[0]) && (temp1[1] != temp2[1]) && (temp1[2] != temp2[2]);
    }
}
