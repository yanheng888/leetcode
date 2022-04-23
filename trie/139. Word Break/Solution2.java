class Solution {
    HashSet<String> st;
    HashMap<String,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        st = new HashSet();
        map = new HashMap();
        for(String word:wordDict){
            st.add(word);
        }
        return dfs(s);
    }
    public boolean dfs(String s){
        int n = s.length();
        if(n==0){
            return true;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i=0;i<n;i++){
            if(st.contains(s.substring(0,i+1))){
                boolean flag = dfs(s.substring(i+1));
                if(flag == true){
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
}
