本题的本质就是在s中找一个最长的、起点在左端点的回文串。然后将s除去回文串的后端复制、翻转并拼接在原s串的前端，就是最优的答案。

所以此题的本质就是Manacher的模板题005.Longest-Palindromic-Substring，求出每个位置作为中心能够构造的最长回文串，查看这个回文串是否能抵达s的最左端，是的话就记录下这个回文串的长度L。输出的答案是：

```
string temp = s.substr(R);
reverse(temp.begin(), temp.end());
return temp+s;
```

需要注意的是l是t中palindrome的字符长度，不包括#
```
if(i-arr[i] == 0){
  // l = (arr[i]*2+1)/2 = arr[i],the number of longest palindrome in s
  /// without #
  l = arr[i];
  }
```
            
