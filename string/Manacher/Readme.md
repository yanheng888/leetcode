

```
for (int i = 0; i < t.length(); i++) {
    if(i > right){
        r = 0;
    }else{
        r = Math.min(dp[2*center-i],right-i);
    }

    while(i >= r && i+r < m && t.charAt(i+r) == t.charAt(i-r)){
        r++;
    }
    dp[i] = r-1;
    if(center+dp[i] > right){
        center = i;
        right = center+dp[i];
    }
}
```

Manacher 核心概念：
* 一个dp[i]: radius of longest palindromic centered at i
* 变量center: center of longest palindromic
* 变量right: right edge of longest palindromic
* 变量j: j与i关于 center对称

遍历字符串，如果i < right => i在longest palindromic范围内 => r = Math.min(dp[2*center-i],right-i);

反之，r = 0，从0开始计算r. r表示radius

xxxx{xjxx(center)xxi(right)}xxx
