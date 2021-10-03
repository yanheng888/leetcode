import java.util.Stack;

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int cnt = nums.length - k;
        
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek() > nums[i] && cnt > 0){
                stack.pop();
                cnt--;
            }
            stack.add(nums[i]);
        }
        while(!stack.isEmpty() && cnt > 0){
            stack.pop();
            cnt--;
        }
        int[] ret = new int[k];
        while (!stack.isEmpty()){
            ret[k-1] = stack.pop();
            k--;
        }
        return ret;
    }
}
