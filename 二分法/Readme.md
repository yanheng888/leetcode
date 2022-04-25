
**模版一**
```
l=-1,r=N
while (l+1 != r){ 
    int mid = low+(high-low)/2;
    if(isBlue(mid)){
        l = m;
    }else{
        r = m; 
    }
}
return l or r
```

例子：[1,2,3,5,5,5,8,9]

Attempt | 
first >=5 element |
last <5 element | 
first >5 element | 
last <=5 element |

| Attempt | isBlue condition | return |blue red |
| :---: | :---: | :---: | :---: |
| first >=5 element | <5 | r | [[1,2,3],[5,5,5,8,9]]
| last <5 element | <5 | l |[[1,2,3],[5,5,5,8,9]]
| first >5 element | <=5 | r | [[1,2,3,5,5,5],[8,9]]
| last <=5 element | <=5 | l | [[1,2,3,5,5,5],[8,9]]

It's easy to see from abour that we can get all four different result by changing isBlue()condition and return l or r.


**模版二**
leetcode 34
```
int l = 0, r = n-1;
int[] res = new int[2];
while (l<r){ // l should not be equal to r for sake of loop forever
    int m = l+(r-l)/2; //if l = m+1, then m should be closer to l
    if(nums[m] < target){
        l = m+1;
    }else{
        r = m;
    }
}
```
```
while (l<r){
    int m = l+(r-l+1)/2; if l = m-1, then m should be closer to r
    if(nums[m] <= target){
        l = m;
    }else {
        r = m-1;
    }
}
```

参考链接：https://www.youtube.com/watch?v=JuDAqNyTG4g
