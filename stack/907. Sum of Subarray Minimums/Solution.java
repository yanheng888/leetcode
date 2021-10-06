import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int M = 1000000007;
        Stack<Integer> stack = new Stack<>();

        int[] preSmaller = new int[n];
        Arrays.fill(preSmaller,-1);

        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller,n);
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                nextSmaller[stack.peek()] = i;
                stack.pop();
            }
            stack.add(i);
        }
        stack.clear();

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                preSmaller[stack.peek()] = i;
                stack.pop();
            }
            stack.add(i);
        }

        long ret = 0;
        for(int i = 0; i < n; i++){
            long l = preSmaller[i];
            long r = nextSmaller[i];
            ret += (i - l) * (r - i) * arr[i];
            ret %= M;
        }
        return (int)(ret % M);
    }
}
