**Solution: greedy**

Notice:
- only when two interval are not overlapping, then we update r
```
for (int i = 1; i < n; i++) {
    if(r <= intervals[i][0]){
        cnt++;
        r = intervals[i][1];
    }
}
```
