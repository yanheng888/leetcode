class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length()-1, n = num2.length()-1;

        int carry = 0;
        StringBuilder s = new StringBuilder();
        while(m >= 0 || n >= 0 || carry > 0){
            int a = m >= 0 ? (num1.charAt(m--)-'0') : 0;
            int b = n >= 0 ? (num2.charAt(n--)-'0') : 0;
            int sum = carry+a+b;
            s.insert(0,sum%10);
            carry = sum/10;
        }

        return s.toString();
    }
}

//123,11
