import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ret[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }
        return ret;
    }
}
