import java.util.HashMap;

class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n < k){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int flag = 1;
        for(Character key:map.keySet()){
            if(map.get(key) < k){
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            return s.length();
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) < k){
                continue;
            }
            int j = i;
            while (j < s.length() && map.get(s.charAt(j)) >= k){
                j++;
            }
            res = Math.max(res,longestSubstring(s.substring(i,j),k));
            i=j;
        }
        return res;
    }
}
