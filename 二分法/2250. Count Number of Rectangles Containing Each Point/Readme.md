```
1 <= li, xj <= 10^9
1 <= hi, yj <= 100
```
The number of h can be considered as O(1).Thus,we can bfs li,xj but loop over hi,yj

Loop over each point,for each point
```
for(int[] point:points){
    int l = point[0];
    int h = point[1];
    int cnt = 0;
    for (int i = h; i < 101; i++) {
        if(map.containsKey(i)){
            cnt += map.get(i).size()-bfs(map.get(i),l);
        }
    }
    res[j++]=cnt;
}
```
if a rectangle's l and h are both >= this point, then this rectangle include this point. So, and all l >= l_j will also be a rectangle include this point.

We need a map.It's key is height of each rec, and value is a list of l in the height of h.
```
for(int[] rec:rectangles){
    List<Integer> lst = map.getOrDefault(rec[1], new ArrayList<>());
    lst.add(rec[0]);
    map.put(rec[1],lst);
}
```

Additionally,we need to do bfs. Thus, the list in map must be sorted
```
for (int key:map.keySet()){
    Collections.sort(map.get(key));
}
```
