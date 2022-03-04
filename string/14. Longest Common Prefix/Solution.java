class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            m = Math.min(m, strs[i].length());
        }
        int i = 0;
        int maxLen = 0;

        for (int len = 1; len <= m; len++) {
            boolean flag = true;
            for (int j = 1; j < n; j++) {
                if(strs[j].charAt(len-1) != strs[j-1].charAt(len-1)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                maxLen = Math.max(maxLen,len);
            }else{
                break;
            }
        }
        return strs[0].substring(0,maxLen);
    }
}
