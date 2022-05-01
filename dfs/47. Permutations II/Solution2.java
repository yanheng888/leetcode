import java.util.*;

class Solution {
    boolean[] memo;
    List<List<Integer>> res;
    int[] nums;
    HashSet<List<Integer>> st;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        memo = new boolean[n];
        this.nums = nums;
        st = new HashSet<>();
        res = new LinkedList();
        dfs(new ArrayList<>(),0);
        return res;
    }

    private void dfs(ArrayList<Integer> arr, int cur) {
        int n = nums.length;
        if(cur > n){
            return;
        }
        if(arr.size() == n){
            ArrayList<Integer> temp = new ArrayList<>(arr);
            if(!st.contains(temp)){
                res.add(temp);
                st.add(temp);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if(memo[i]){
                continue;
            }
            memo[i] = true;
            arr.add(nums[i]);
            dfs(arr,i+1);
            arr.remove(arr.size()-1);
            memo[i] = false;
        }
    }
}
