Stack: monotonic stack
栈问题通常和数组有关，最首要的问题是确认何时出栈，何时入栈。通常来说，代码结构如下：

for(int i = 0; i < nums.length; i++)
{
    while (!stack.isEmpty() && 出栈条件 == true)
    {
      处理逻辑
      stack.pop()
    }
    //不出栈则入栈
  stack.add(i);
}
有时候，题目并不会明显的告诉本问题是何时入栈出栈，甚至不像个栈问题。这时需要做一些转换，将题目转换成栈问题，如leetcode 255,84,85
1.给定一个数组nums， 用单调栈求next greater /next smaller /previous smaller/previous greater element:
```
for(int i = 0; i < nums.length; i++)
{
    while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
    {
      int height = nums[stack.pop()];
      int width = i - stack.peek() - 1;
      ret = Math.max(ret, width * height);
    }
  stack.add(i);
}//leetcode 84
```

2 给定一个数组nums， 用单调栈生成next greater /next smaller /previous smaller/previous greater element等数组，然后再用这些数组判定是否满足题目条件，最后得出答案
leetcode 1966,255
```
long ret = 0;
for(int i = 0; i < n; i++){
  long pre = preSmaller[i] == -1 ? 0 : preSum[preSmaller[i]];
  long next = preSum[nextSmaller[i] - 1];
  ret = Math.max(ret , nums[i] * (next - pre));
}//leetcode 1856
```

```
long ret = 0;
for(int i = 0; i < n; i++){
  long l = preSmaller[i];
  long r = nextSmaller[i];
  ret += (i - l) * (r - i) * arr[i];
  ret %= M;
}//leetcode 907
```

Stack:parse expression
Stack:parse expression 问题通常和字符串处理，括号有关，最首要的问题是确认何时出栈，何时入栈。通常来说，"("时入栈，“）”时出栈。入栈时，直接入栈。出栈时则需要做更多的处理，如获取字符串的数字，获取特定的字段等。常用的方法有 Character.isDigit(),Character.isLowerCase,Integer.parseInt(),String.substring(),String.valueOf
