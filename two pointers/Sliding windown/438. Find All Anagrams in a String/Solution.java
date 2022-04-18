class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        int[] map2 = new int[26];
        ArrayList<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(m > n){
            return res;
        }
        for(int i=0;i<m;i++){
            map[p.charAt(i)-'a']++;
            map2[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(map,map2)){
            res.add(0);
        }
        for(int i=m;i<n;i++){
            map2[s.charAt(i)-'a']++;
            map2[s.charAt(i-m)-'a']--;
            if(Arrays.equals(map,map2)){
                res.add(i-m+1);
            }
        }
        return res;
    }
}
