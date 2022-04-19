
和 two sum相似，利用前缀和数组和hashmap求出答案

注意
- map.containsKey(preSum-k) 为true,则加上该频率：
```
for(int num:nums){
    preSum += num;
    if(map.containsKey(preSum-k)){
        res += map.get(preSum-k);
    }
    map.put(preSum,map.getOrDefault(preSum,0)+1);
}
```
- presum 为 nums[0:i]的前缀和，包括当前nums[i]
- map要记录每个presum的频率


preSum-k的原理是：
```
presum[j]-presum[i-1] = nums[i]+nums[i+1]+...+nums[j]. 
假设sum(nums[i:j])=k => presum[j]-presum[i-1]=k => presum[i-1] = presum[j]-k
```
这个presum[i-1]为之前的presum. 对于每一个presum[j],只要hashmap 存在 presum[i-1] = presum[j]-k，就可以凭凑出k。
