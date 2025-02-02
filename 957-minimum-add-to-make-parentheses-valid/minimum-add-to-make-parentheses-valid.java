class Solution {
    public int minAddToMakeValid(String s) {
        int openPara = 0;
        int closePara = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openPara += 1;
            } else {
                if (openPara > 0) {
                    openPara -= 1;
                }
            }

            if (s.charAt(s.length() - i - 1) == ')') {
                closePara += 1;
            } else {
                if (closePara > 0) {
                    closePara -= 1;
                }
            }
        }
        return closePara + openPara;
    }
}