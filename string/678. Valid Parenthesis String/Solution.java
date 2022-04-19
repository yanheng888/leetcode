class Solution {
    public boolean checkValidString(String s) {
        int lower=0;
        int upper=0;

        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if (c=='(')
            {
                lower++;
                upper++;
            }
            else if (c=='*')
            {
                lower--;
                upper++;
            }
            else if (c==')')
            {
                lower--;
                upper--;
            }

            if (lower<0) lower=0;

            if (upper<0) return false;
        }

        return lower==0;
    }
}
