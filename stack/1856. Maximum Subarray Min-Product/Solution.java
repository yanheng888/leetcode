import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;



public class Solution {
    int M = 1000000007;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        //preSmaller[i] is the index of previous smaller number
        int[] preSmaller = new int[n];
        Arrays.fill(preSmaller,-1);

        //nextSmaller[i] is the index of next smaller number
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller,n);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                nextSmaller[stack.pop()] = i;
            }
            stack.add(i);
        }
        stack.clear();

        for(int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                preSmaller[stack.pop()] = i;
            }
            stack.add(i);
        }

        //preSum[i] is (nums[0] + nums[1] + ... + nums[i])
        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            preSum[i] = nums[i] + preSum[i-1];
        }

        long ret = 0;
        for(int i = 0; i < n; i++){
            long pre = preSmaller[i] == -1 ? 0 : preSum[preSmaller[i]];
            long next = preSum[nextSmaller[i] - 1];
            ret = Math.max(ret , nums[i] * (next - pre));
        }
        return (int)(ret % M);
    }
}
