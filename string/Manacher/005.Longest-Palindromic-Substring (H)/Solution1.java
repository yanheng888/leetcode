class Solution {
    public String longestPalindrome(String s) {
        StringBuilder t = new StringBuilder();
        t.append("#");
        for (int i = 0; i < s.length(); i++) {
            t.append(s.charAt(i)).append("#");
        }
        int n = t.length();
        int center = -1, right = -1;
        int k;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if(i > right){
                k = 0;
            }else{
                k = Math.min(arr[center*2-i], arr[right-i]);
            }
            while (i-k>=0 && i+k < n && t.charAt(i-k) == t.charAt(i+k)){
                k++;
            }
            arr[i] = k - 1;
            if(arr[i]+i > right){
                center = i;
                right = arr[i]+i;
            }
        }
        int maxLen = -1;
        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]>maxLen)
            {
                maxLen = arr[i];
                center = i;
            }
        }
        int left = center/2 - maxLen/2;
        return s.substring(left, left+maxLen);
    }
}
