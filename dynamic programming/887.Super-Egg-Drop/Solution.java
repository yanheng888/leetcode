import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> memo;
    public int superEggDrop(int k, int n) {
        memo = new HashMap<>();
        return dp(k, n);
    }

    private int dp(int k, int n) {
        int key = n*100+k;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int ans;
        if(k == 1 || n == 1){
            ans = n;
        }else if(k == 0 || n == 0){
            ans = 0;
        }else{
            int lo = 1, hi = n;
            while(lo + 1 < hi){
                int x = (lo + hi) / 2;
                int t1 = dp(k-1,x-1);
                int t2 = dp(k,n-x);

                if(t1 == t2){
                    lo = hi = x;
                }else if(t1 < t2){
                    lo = x;
                }else{
                    hi = x;
                }
            }
            ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
        }
        memo.put(key,ans);
        return ans;
    }

}
