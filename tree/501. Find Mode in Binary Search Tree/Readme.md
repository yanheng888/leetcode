root是bst,需要求modes.如果将bst想像成一个sorted list则可以简化题目.使用in order traverse遍历bst, 则相当于从左至右依次遍历sorted list. 

这时，使用pre记录上一个访问的element, 如果当前访问的element等于pre，则cnt++.cnt是当前访问元素的frequency.否则，就表明遇到了新元素，这时重置cnt = 1, pre = root
```
if(pre.val == root.val){
                cnt++;
            }else{
                cnt = 1;
                pre = root;
            }
```

为了记录mode, 我们需要最大frequecy, 也就是不断更新cnt，记录cnt最大值。当出现新的cnt最大值，则说明我们遇到了新的mode,这时丢掉旧的mode, 记录新的mode

```
if(cnt > modeFreq){
            modes.clear();
            modes.add(root.val);
            modeFreq = cnt;
        }else if(cnt == modeFreq){
            modes.add(root.val);
        }
```
