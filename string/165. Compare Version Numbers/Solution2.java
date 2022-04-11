class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        return dfs(arr1,0,arr2,0);
    }

    private int dfs(String[] arr1, int i, String[] arr2, int j) {
        if(i >= arr1.length && j >= arr2.length){
            return 0;
        }
        int a = 0, b = 0;
        if(i < arr1.length){
            a = Integer.parseInt(arr1[i]);
        }
        if(j < arr2.length){
            b = Integer.parseInt(arr2[j]);
        }
        if(a < b){
            return -1;
        }else if(a > b){
            return 1;
        }
        return dfs(arr1,i+1,arr2,j+1);
    }
}
