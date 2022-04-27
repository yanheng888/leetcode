

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Integer,String>> pq = new PriorityQueue(new Comparator<Pair<Integer,String>>() {
            @Override
            public int compare(Pair<Integer,String> o1, Pair<Integer,String> o2) {
                return o2.getKey()-o1.getKey();
            }
        });
        if(a>0){
            pq.add(new Pair<>(a,"a"));
        }
        if(b>0){
            pq.add(new Pair<>(b,"b"));
        }
        if(c>0){
            pq.add(new Pair<>(c,"c"));
        }
        StringBuilder res = new StringBuilder();
        Pair<Integer,String> arr1;
        Pair<Integer,String> arr2;
        while (!pq.isEmpty()){
            if(pq.size() == 1){
                arr1 = pq.poll();
                for (int i = 0; i < Math.min(2,arr1.getKey()); i++) {
                    res.append(arr1.getValue());
                }
                return res.toString();
            }
            arr1 = pq.poll();
            arr2 = pq.poll();
            int k = Math.min(2,(arr1.getKey()-arr2.getKey())+1);
            for (int i = 0; i < Math.min(2,k); i++) {
                res.append(arr1.getValue());
            }
            res.append(arr2.getValue());
            arr1 = new Pair<>(arr1.getKey()-k,arr1.getValue());
            arr2 = new Pair<>(arr2.getKey()-1,arr2.getValue());
            if(arr1.getKey() > 0){
                pq.add(arr1);
            }
            if(arr2.getKey() > 0){
                pq.add(arr2);
            }
        }
        return res.toString();
    }
}
