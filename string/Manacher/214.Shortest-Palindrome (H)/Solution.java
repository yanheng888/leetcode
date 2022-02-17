
class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder t = new StringBuilder();
        //格式为 #c#,每个字符两边都有#，这样才使得每个字符都是palindrome
        t.append("#");
        for (int i = 0; i < s.length(); i++) {
            t.append(s.charAt(i)).append("#");
        }

        int n = t.length();
        int center = -1, right = -1;
        int k;
        int[] arr = new int[n];
        String res = s;
        // the number of longest palindrome in s
        int l = -1;
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
            if(i-arr[i] == 0){
                // l = (arr[i]*2+1)/2 = arr[i],the number of longest palindrome in s
                /// without #
                l = arr[i];
            }
        }
        res = new StringBuilder(s.substring(l)).reverse().toString();
        return res+s;
    }
}
//'aaa'
