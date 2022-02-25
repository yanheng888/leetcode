class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.length() == 0){
            return 0;
        }

        for (int i = 0; i+needle.length() <= haystack.length(); i++) {
            boolean f = true;
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    f = false;
                    break;
                }
            }
            if(f){
                return i;
            }
        }
        return -1;
    }
}

//aaaaa,bba
