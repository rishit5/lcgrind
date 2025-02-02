class Solution {
    public boolean checkValidString(String s) {
        int openString = 0;
        int closeString = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openString += 1;
            } else {
                openString -= 1;
            }

            if (s.charAt(s.length() - i - 1) == ')' || s.charAt(s.length() - i - 1) == '*') {
                closeString += 1;
            } else {
                closeString -= 1;
            }

            if (openString < 0 || closeString < 0) {
                return false;
            }
        }

        return true;
    }
}