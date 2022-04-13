class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];
        int force = 0;
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if(c == 'R'){
                force = n;
            }else if(c == 'L'){
                force = 0;
            }else{
                force = Math.max(force-1,0);
            }
            forces[i] += force;
        }

        for (int i = n-1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if(c == 'L'){
                force = n;
            }else if(c == 'R'){
                force = 0;
            }else{
                force = Math.max(force-1,0);
            }
            forces[i] -= force;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(forces[i] < 0){
                res.append("L");
            }else if(forces[i] > 0){
                res.append("R");
            }else{
                res.append(".");
            }
        }
        return res.toString();
    }
}
