import java.util.*;

class Solution {
    boolean[] memo;
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        memo = new boolean[n];
        this.nums = nums;
        Arrays.sort(nums);
        res = new LinkedList<>();
        dfs(new ArrayList<>(),0);
        return res;
    }

    private void dfs(ArrayList<Integer> arr, int idx) {
        int n = nums.length;
        if(idx > n){
            return;
        }
        if(arr.size() == n){
            res.add(new LinkedList<>(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(memo[i] || (i > 0 && nums[i] == nums[i - 1] && memo[i - 1])){
                continue;
            }
            memo[i] = true;
            arr.add(idx,nums[i]);
            dfs(arr,idx+1);
            arr.remove(idx);
            memo[i] = false;
        }
    }
}
