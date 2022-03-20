https://maomaoalgo.gitbook.io/python/hui-su-yu-dong-tai-gui-hua/bei-bao-dp


为什么0-1背包问题需要用倒序？

首先需要知道正序和倒序的效果，当使用正序时有累积效果，使用倒序无累积。比如leetcode 416:

nums = [1,5,11,5] ,n = 4
```
      0,1,2,3,4,5,6,7,8,9,0,1
dp = [t,f,f,f,f,f,f,f,f,f,f,f]


for (int i = 0; i < n; i++) {
    int num = nums[i];
    for (int j = num; j <= 11; j--) {
        dp[j] |= dp[j-num];
    }
}
```

当 num = 1

```
      0,1,2,3,4,5,6,7,8,9,0,1
dp = [t,t,t,t,t,t,t,t,t,t,t,t]

倒序时，当num = 1:
      0,1,2,3,4,5,6,7,8,9,0,1
dp = [t,t,f,f,f,f,f,f,f,f,f,f]

num = 5:

      0,1,2,3,4,5,6,7,8,9,0,1
dp = [T,T,f,f,f,T,T,f,f,f,f,f]

num = 11:
      0,1,2,3,4,5,6,7,8,9,0,1
dp = [T,T,f,f,f,T,T,f,f,f,f,T]

num = 5:
      0,1,2,3,4,5,6,7,8,9,0,1
dp = [T,T,f,f,f,T,T,f,f,f,T,T]

```
