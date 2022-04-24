
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

参考链接：https://www.youtube.com/watch?v=JuDAqNyTG4g
