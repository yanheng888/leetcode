class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, ret = 0;
        if(s.length() == 0){
            return 0;
        }
        boolean[] visited = new boolean[256];
        while (j < s.length()){
            char ch = s.charAt(j);
            if(visited[ch]){
                visited[s.charAt(i)] = false;
                i++;
            }else{
                visited[ch] = true;
                ret = Math.max(ret, j-i+1);
                j++;
            }
        }
        return ret;
    }
}
