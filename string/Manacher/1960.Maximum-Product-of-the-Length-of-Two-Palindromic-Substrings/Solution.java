class Solution {
    public long maxProduct(String s) {
//        StringBuilder t = new StringBuilder();
//        //格式为 #c#,每个字符两边都有#，这样才使得每个字符都是palindrome
//        t.append("#");
//        for (int i = 0; i < s.length(); i++) {
//            t.append(s.charAt(i)).append("#");
//        }
        String t = s;
        int n = t.length();
        int center = -1, right = -1;
        int k;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if(i > right){
                k = 0;
            }else{
                k = Math.min(arr[center*2-i], arr[right-i]);
            }
            while (i-k>=0 && i+k < n && t.charAt(i-k) == t.charAt(i+k)){
                k++;
            }
            arr[i] = k - 1;

            if(arr[i]+i > right){
                center = i;
                right = arr[i]+i;
            }
        }
        long[] l = new long[n];
        long[] r = new long[n];
        l[0] = 1;
        r[n-1] = 1;
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j < arr.length && j+arr[j] < i){
                j++;
            }
            l[i] = Math.max((i-j)*2+1,l[i-1]);
        }

        j = n-1;
        for (int i = n-2; i >= 0; i--) {
            while (j >=0 && j-arr[j] > i){
                j--;
            }
            r[i] = Math.max((j-i)*2+1,r[i+1]);
        }

        long res = 0;
        for (int i = 0; i < n-1; i++) {
            res = Math.max(res,l[i]*r[i+1]);
        }
        return res;
    }
}
//'aaa'
