import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int[] preGreater = new int[n];
        Arrays.fill(preGreater, -1);
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, n);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                nextSmaller[stack.peek()] = i;
                stack.pop();
            }
            stack.add(i);
        }
        stack.clear();

        for(int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                preGreater[stack.peek()] = i;
                stack.pop();
            }
            stack.add(i);
        }

        int ret = 0;
        for(int i = 0; i < n; i++){
            if(preGreater[i] == -1 && nextSmaller[i] == n){
                ret++;
            }
        }
        return ret;
    }
}
