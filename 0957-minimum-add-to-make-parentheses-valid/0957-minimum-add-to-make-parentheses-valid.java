class Solution {
    public int minAddToMakeValid(String s) {
        int closeBrac = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                closeBrac += 1;
            } else {
                if (closeBrac != 0) {
                    closeBrac -= 1;
                } 
            }
        }

        int openBrac  = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                openBrac += 1;
            } else {
                if (openBrac != 0) {
                    openBrac -= 1;
                }
            }
        }

        return closeBrac + openBrac;
    }
}