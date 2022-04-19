leetcode560:

前缀和数组1:
```
int[] nums = new int[]{1,2,3};
int[] preSum = new int[nums.length+1];
for(int i=1;i<=nums.length;i++){
    preSum[i] = preSum[i-1]+nums[i-1];
}
```
此时preSum = [0,1,3,6]. preSum[i]为 i之前的presum，不包含nums[i]. preSum[j+1]-preSum[i] = nums[i]+nums[i+1]+...+nums[j]


前缀和数组2:
```
int[] preSum = new int[nums.length];
preSum[0] = nums[0];
for(int i=1;i<nums.length;i++){
    preSum[i] = preSum[i-1]+nums[i];
}
```
此时preSum = [1,3,6]. preSum[i]为 sum(nums[0:i])的presum，包含nums[i]. preSum[j]-preSum[i-1] = nums[i]+nums[i+1]+...+nums[j]


两个前缀和数组区别：
- 长度相差一
- 包含，或不包含当前nums[i]
- 计算sum(nums[i:j])公式不同
