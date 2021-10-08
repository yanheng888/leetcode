import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        //每列数是一个bar，如果基层为0则该bar height is 0; 如果基层不为0， 则height 为 挨着基层的连续1的个数
        int[] arr = new int[cols];
        int ret = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //given matrix type is char
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                }else{
                    arr[j] += 1;
                }
            }
            ret = Math.max(ret, helper(arr));
        }
        return ret;
    }

    public int helper(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[heights.length + 2];
        nums[0] = 0;
        nums[heights.length + 1] = 0;
        for(int i = 1; i <= heights.length; i++){
            nums[i] = heights[i-1];
        }
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            if(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                    int height = nums[stack.pop()];
                    int width = i - stack.peek() - 1;
                    ret = Math.max(ret, width * height);
                }

            }
            stack.add(i);
        }
        return ret;
    }
}
