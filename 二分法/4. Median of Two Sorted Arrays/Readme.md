
易出错点：
* maxLX，maxLY,minRX,minRY,pivx,pivy 变量名称错误
* 中位点判断条件错误： if(maxLX <= minRY && maxLY <= minRX)

注意：
- LX = nums[0,pivx-1], RX=nums[pivx:n1]
- pivy dependend on pivx, we will only change pivx in binary search
```
int pivx = (left+right)/2;
//pivy is determined by pivx, pivx decrease cause pivy increase
int pivy = (n1+n2+1)/2 - pivx;
//pivx=0 means there is no element in LX
int maxLX = pivx == 0 ? Integer.MIN_VALUE : nums1[pivx-1];
int maxLY = pivy == 0 ? Integer.MIN_VALUE : nums2[pivy-1];

//pivx=n1 means there is no element in RX
int minRX = pivx == n1 ? Integer.MAX_VALUE : nums1[pivx];
int minRY = pivy == n2 ? Integer.MAX_VALUE : nums2[pivy];
```

https://www.youtube.com/watch?v=LPFhl65R7ww&t=658s
