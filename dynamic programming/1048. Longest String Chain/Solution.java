import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(check(words[i],words[j])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    private boolean check(String word, String word2) {
        int m = word.length(), n = word2.length();
        if(m < n){
            return check(word2,word);
        }
        if(m != n+1){
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n){
            if(word.charAt(i) == word2.charAt(j)){
                j++;
            }
            i++;
        }
        return (j==n);
    }
}
