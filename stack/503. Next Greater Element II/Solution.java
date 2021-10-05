import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        for(int j = 0; j < nums.length * 2; j++){
          // i -= nums.length, 不影响 j 的值，所以不会有无限循环
            int i = j;
            if (i >= nums.length){
                i -= nums.length;
            }
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ret[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.add(i);
        }
        return ret;
    }
}
