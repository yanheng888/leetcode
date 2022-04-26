**Solution: template1**

常规的二分搜索，目标是右区间的第一个元素。如果中位数nums[k]>=nums[0]，那么说明k在左区间，我们将搜索范围调整为[k+1,j]。如果中位数nums[k]<nums[0]，那么说明k在右区间，我们将搜索范围调整为[i,k]。

因为此题必然有解，所以当收敛到i==j时，就是答案。


**Solution: template2**

- while(l<r) to avoid forever loop
- return r+1 rather than l+1. suppose input [4,5,1,2,3], after loop l=0,r=1,nums[r+1] is the answer we are looking for.
- r keep pushing to left of m while nums[m] is in right interval however l may stay at same position. r=m-1,r+1=m and m is the answer
