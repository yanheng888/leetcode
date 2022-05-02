class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int res = 0;
        int flip = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (flip < k || answerKey.charAt(j) == 'T')){
                if(answerKey.charAt(j) == 'F'){
                    flip++;
                }
                j++;
            }
            if(answerKey.charAt(i) == 'F'){
                flip--;
            }
            res = Math.max(res,j-i);
        }
        flip = 0;
        j=0;
        for (int i = 0; i < n; i++) {
            while (j < n && (flip < k || answerKey.charAt(j) == 'F')){
                if(answerKey.charAt(j) == 'T'){
                    flip++;
                }
                j++;
            }
            if(answerKey.charAt(i) == 'T'){
                flip--;
            }
            res = Math.max(res,j-i);
        }
        return res;
    }
}
