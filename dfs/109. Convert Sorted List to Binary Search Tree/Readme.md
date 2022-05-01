**Solution: divide and conquer + dfs**

Notice:
- getMedian() if fast.next != right,break
```
while(fast != right && fast.next != right){
    slow = slow.next;
    fast = fast.next;
    if(fast == null){
        break;
    }
    fast = fast.next;
}
```
