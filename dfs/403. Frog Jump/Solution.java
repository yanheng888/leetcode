import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    HashMap<Integer,Integer> map;
    HashSet<Integer> st;
    HashSet<String> fails;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        map = new HashMap<>();
        st = new HashSet<>();
        fails = new HashSet<>();
        for (int stone:stones) {
            st.add(stone);
        }
        return dfs(stones,0,0);
    }

    private boolean dfs(int[] stones,int pos, int move) {
        if(pos == stones[stones.length-1]){
            return true;
        }
        if(!st.contains(pos) || fails.contains(""+pos+""+move)){
            return false;
        }
//        if(pos+move-1)
        boolean res = false;
        if(move > 1 && dfs(stones,pos+move-1,move-1)){
            return true;
        }
        if(move > 0 && dfs(stones,pos+move,move)){
            return true;
        }
        if(dfs(stones,pos+move+1,move+1)){
            return true;
        }
        fails.add(""+pos+""+move);
        return false;
    }

}
