class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList();
        res.add(0);
        for(int i=0;i<n;i++){
            int m = res.size();
            for(int j=m-1;j>=0;j--){
                res.add(res.get(j)|(1<<(i)));
            }
        }
        return res;
    }
}
