class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            map.add(new ArrayList<>());
        }
        int cnt = 0;
        for(int[] pair: prerequisites){
            map.get(pair[1]).add(pair[0]);
            inDegree[pair[0]]++;
        }
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.add(i);
                cnt++;
            }
        }
        int i=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[i++] = cur;
            for(int next:map.get(cur)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.add(next);
                    cnt++;
                }
            }
        }
        if(cnt != numCourses){
            return new int[0];
        }
        return res;
    }
}
