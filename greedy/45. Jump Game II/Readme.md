Solution1:正向查找可到达的最大位置
注意点：
- 如果 i+nums[i] >= n-1，立刻返回操作数，因为已经到达终点
- nums[j]+j 表示当前点能到达的最远距离，maxx <= nums[j]+j 尽可能往后面移动，即使maxx == nums[j]+j


Solution2: 反向查找出发位置
