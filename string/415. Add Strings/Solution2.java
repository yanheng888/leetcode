class Solution {
    public String addStrings(String s1, String s2) {
        while(s1.length() < s2.length()){
            s1 = "0"+s1;
        }
        while(s2.length() < s1.length()){
            s2 = "0"+s2;
        }
        int n = s1.length();
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            int a = s1.charAt(i)-'0';
            int b = s2.charAt(i)-'0';
            res.insert(0,(carry+a+b)%10);
            carry = (carry+a+b)/10;
        }
        if(carry == 1){
            res.insert(0,"1");
        }
        return res.toString();
    }
}
