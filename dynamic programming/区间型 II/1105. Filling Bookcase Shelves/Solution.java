import java.util.Arrays;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = books[0][1];
        for (int i = 0; i < n; i++) {
            int width = books[i][0];
            int height = books[i][1];
            if(i == 0){
                dp[i] = height;
            }else {
                dp[i] = height+dp[i-1];
            }
            int j = i-1;
            while (j>=0 && books[j][0]+width <= shelfWidth){
                width += books[j][0];
                height = Math.max(height,books[j][1]);
                if(j == 0){
                    dp[i] = Math.min(dp[i],height);
                }else{
                    dp[i] = Math.min(dp[i],dp[j-1]+height);
                }
                j--;
            }
        }
        return dp[n-1];
    }
}
