
**Solution: quick select**

算出数组的每个数的频率，选出频率第K高的数，然后遍历所有数，如果该数频率>= 第K频率则记录在数组里

注意点：
- quickSelect()递归时，根据i,j,t来区分区间,作为参数不要变量名写错
- quickSelect()各个区间的长度不要计算错误


**Solution2: binary search by value**

notice:
- count(m)<=k means there are less or equal number of number whose frequency is equal to m

**Solution3: heap**

notice:
- loop through hashmap since all key are unique rather than nums which includes duplicate number
```
for (int num:map.keySet()) {
    if(pq.size()!=k){
        pq.add(new int[]{num,map.get(num)});
    }else{
        if(!pq.isEmpty() && pq.peek()[1] < map.get(num)){
            pq.poll();
            pq.add(new int[]{num,map.get(num)});
        }
    }
}
```
参考链接：https://www.youtube.com/watch?v=6hjV-IdrOd0
