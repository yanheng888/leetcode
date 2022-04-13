import java.util.List;

class Solution {
    int[] memo;
    class Node{
        boolean isEnd = false;
        Node[] next = new Node[26];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Node root = new Node();
        this.memo = new int[s.length()];
        for (String word: wordDict){
            Node temp = root;
            for(char c: word.toCharArray()){
                if(temp.next[c-'a'] == null){
                    temp.next[c-'a'] = new Node();
                }
                temp = temp.next[c-'a'];
            }
            temp.isEnd = true;
        }
        return dfs(root,0,s);
    }

    private boolean dfs(Node root, int cur, String s) {
        if(cur >= s.length()){
            return true;
        }
        if(memo[cur] == 1){
            return false;
        }
        Node node = root;
        for (int j = cur; j < s.length(); j++) {
            Node temp = node.next[s.charAt(j)-'a'];
            if(temp != null){
                if(temp.isEnd == true && dfs(root,j+1,s)){
                    return true;
                }
            }else{
                break;
            }
            node = node.next[s.charAt(j)-'a'];
        }
        memo[cur] = 1;
        return false;
    }
}
