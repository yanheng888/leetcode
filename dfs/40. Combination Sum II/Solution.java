import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    boolean[] memo;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        res = new ArrayList<>();
        memo = new boolean[n];
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList());
        return res;
    }

    private void dfs(int[] candidates, int target, int index,List<Integer> arr) {
        int n = candidates.length;
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = index; i < n; i++) {
            if(i > index && candidates[i]==candidates[i-1]){
                continue;
            }
            arr.add(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
