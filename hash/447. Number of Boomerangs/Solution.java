class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int[] p : points){
            map.clear();
            for(int[] q:points){
                int dist = (p[0]-q[0])*(p[0]-q[0])+(p[1]-q[1])*(p[1]-q[1]);
                map.put(dist,map.getOrDefault(dist,0)+1);
            }
            for(Integer key:map.keySet()){
                res += map.get(key)*(map.get(key)-1);
            }
        }
        return res;
    }
}
