import java.util.Arrays;
import java.util.Collections;

class Solution {
    int total;
    int k;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] arr = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        total = 0;
        this.k = k;
        this.visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if(total%k != 0){
            return false;
        }
        return dfs(arr,0,0,0);
    }

    private boolean dfs(int[] arr, int cur, int group,int sum) {
        if(cur >= arr.length){//[4,3,2,3,5,2,1], k = 4 [5,4,3,3,2,2,1]
            return false;
        }
        if(sum == total/k){
            return dfs(arr, 0, group+1, 0);
        }
        if(sum > total/k){
            return false;
        }
        if(group == k){
            return true;
        }
        int last = -1;
        for (int i = cur; i < arr.length; i++) {
            if(visited[i]){
                continue;
            }
            if(sum+arr[i] == last){
                continue;
            }
            visited[i] = true;
            if(dfs(arr,i,group,sum+arr[i])){
                return true;
            }
            last = sum+arr[i];
            visited[i] = false;
        }
        return false;
    }
}
