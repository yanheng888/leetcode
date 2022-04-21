class Solution {
    ArrayList<ArrayList<Integer>> map;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new ArrayList();
        visited = new int[numCourses+1];
        for(int i=0;i<numCourses;i++){
            map.add(new ArrayList());
        }
        for(int[] pair: prerequisites){
            map.get(pair[0]).add(pair[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(dfs(i) == false) return false;
        }
        return true;
    }

    public boolean dfs(int cur){
        if(visited[cur] == 1){
            return true;
        }
        if(visited[cur] == 2){
            return false;
        }
        visited[cur] = 2;
        for(int next:map.get(cur)){
            if(visited[next] == 2){
                return false;
            }
            if(visited[next] == 1){
                continue;
            }
            if(dfs(next) == false){
                return false;
            }
        }
        visited[cur] = 1;
        return true;
    }
}
