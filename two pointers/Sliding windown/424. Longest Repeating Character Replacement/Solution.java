class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        int j = 0, res = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && check(s,cnt,j,j-i+1,k)){
                j++;
            }
            res = Math.max(res,j-i);
            cnt[s.charAt(i)-'A']--;
        }
        return res;
    }

    private boolean check(String s,int[] cnt, int j, int L,int k) {
        cnt[s.charAt(j)-'A']++;
        int maxCnt = 0;
        for (int x:cnt){
            maxCnt = Math.max(x,maxCnt);
        }
        if(L - maxCnt <= k){
            return true;
        }else{
            cnt[s.charAt(j)-'A']--;
            return false;
        }
    }
}
