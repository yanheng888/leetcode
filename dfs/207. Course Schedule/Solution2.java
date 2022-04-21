class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            map.add(new ArrayList<>());
        }
        int cnt = 0;
        for(int[] pair: prerequisites){
            map.get(pair[0]).add(pair[1]);
            inDegree[pair[1]]++;
        }
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.add(i);
                cnt++;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next:map.get(cur)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt==numCourses;
    }
}
