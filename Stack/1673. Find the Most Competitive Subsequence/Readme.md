Create a stack and loop over nums, whenever nums[i] is less than stack peek, pop top element from the stack. The maximum number of pop operation is nums.length - k, thus the stack will have k element in the end.

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek() > nums[i] && cnt > 0){
                stack.pop();
                cnt--;
            }
            stack.add(nums[i]);
        }
