import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] visited = new boolean[26];
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)-'a']++;
        }
        Deque<Character> stk = new LinkedList<>();//"abacb"
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!visited[c-'a']){
                while (!stk.isEmpty() && stk.peekFirst() >= c && map[stk.peekFirst()-'a']>1){
                    visited[stk.peekFirst()-'a'] = false;
                    map[stk.peekFirst()-'a']--;
                    stk.pollFirst();
                }
                visited[c-'a'] = true;
                stk.push(c);
            }else{
                map[c-'a']--;
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()){
            res.append(stk.pollLast());
        }
        return res.toString();
    }
}
