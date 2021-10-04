import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[heights.length + 2];
        //ensure the stack will not be empty
        nums[0] = 0;
        //ensure we will pop all element from stack
        nums[heights.length + 1] = 0;
        for(int i = 1; i <= heights.length; i++){
            nums[i] = heights[i-1];
        }
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            if(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                    int height = nums[stack.pop()];
                    //width is the difference between ith bar and previous bar before current popped bar since there could be
                    // some bar between ith bar and current popped bar had been removed
                    int width = i - stack.peek() - 1;
                    ret = Math.max(ret, width * height);
                }
            }
            stack.add(i);
        }
        return ret;
    }
}
