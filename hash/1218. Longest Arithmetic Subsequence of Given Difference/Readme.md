本题解法和two sum 有相似之处，遍历数组，记录下每个数为结尾的最长序列长度，记录方法就是如果之前有num-diff存在，则在前个数的频率基础上+1
```
for(int i=0;i<n;i++){
    int num = arr[i];
    map.put(num,map.getOrDefault(num-diff,0)+1);//如果之前有num-diff存在，则在前个数的频率基础上+1
    res = Math.max(res,map.get(num));
}
```
