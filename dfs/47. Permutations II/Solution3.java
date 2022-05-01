import java.util.*;

class Solution {
    boolean[] memo;
    List<List<Integer>> res;
    int[] nums;
    int OFFSET = 10;
    class Trie{
        Trie[] next = new Trie[10+OFFSET];
        boolean isEnd = false;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        memo = new boolean[n];
        this.nums = nums;
        res = new LinkedList();
        Trie root = new Trie();
        dfs(new ArrayList<>(),0,root);
        return res;
    }

    private void dfs(ArrayList<Integer> arr, int cur,Trie root) {
        int n = nums.length;
        if(cur > n){
            return;
        }
        if(arr.size() == n){
            ArrayList<Integer> temp = new ArrayList<>(arr);
            if(root.isEnd){
                return;
            }
            root.isEnd = true;
            res.add(temp);
            return;
        }
        Trie temp = root;
        for (int i = 0; i < n; i++) {
            if(memo[i]){
                continue;
            }
            memo[i] = true;
            arr.add(nums[i]);
            int idx = nums[i]+OFFSET;
            if(temp.next[idx]  == null){
                temp.next[idx] = new Trie();
            }
            dfs(arr,i+1,temp.next[idx]);
            arr.remove(arr.size()-1);
            memo[i] = false;
        }
    }
}
