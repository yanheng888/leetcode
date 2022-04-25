
notice:

```
return r = nums[r]>=target ? r:n;
```
- the final result index could be n which is out of array index. If it's this case, return n
- the final result index could be 0 but we can reach index 0, so leave it alone
