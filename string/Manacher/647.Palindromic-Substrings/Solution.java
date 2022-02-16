class Solution {
    public int countSubstrings(String s) {
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
        int res = 0;
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
        for (int i = 0; i < n; i++) {
            res += (arr[i]+1)/2;
        }
        return res;
    }
}
