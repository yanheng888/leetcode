import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    int[] nums;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        this.nums = nums;
        res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        dfs( arr,0);
        return res;
    }

    public void dfs(ArrayList arr,int x){
        if(n == x){
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = x; i < n; i++) {
//            System.out.println(x + " " + i);
            Collections.swap(arr,i,x);
            dfs(arr,x+1);
            Collections.swap(arr,i,x);
        }
    }

}
