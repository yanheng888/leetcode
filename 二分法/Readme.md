
```
while (low < high){ //if low == high, loop will continue forever
    int mid = low+(high-low)/2;
    if(isOk(mid,weights,days)){ // 判定条件
        high = mid;
    }else{
        low = mid+1; //either low = mid+1 or high = mid-1
    }
}
```

二分模版，三个注意点：

* while()条件，low < high, 不能 (low <= high)
* 判定mid是否符合
* low = mid+1 or high = mid
