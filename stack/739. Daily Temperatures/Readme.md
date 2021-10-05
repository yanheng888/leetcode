遍历temperatures。如果栈不为空且当前t大于栈peek(),则**退栈**。否则**入栈**。这样栈始终维护的是单调递减的栈，每当遇到更高的温度，则把所有比这个温度低的栈中的温度退栈，并在**退栈时更新等待天数**


```` 
while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ret[stack.peek()] = i - stack.peek();
                stack.pop();
            }
````
[739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
