class Solution {
    
    private boolean checkNumberOrDecimal(int start, int end, String s) {
        boolean containsDot = false;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == '.') {
                if (containsDot == true) {
                    return false;
                }
                containsDot = true;
            }
        }
        try {
            if (containsDot) {
                Double d = Double.parseDouble(s.substring(start, end));
            } else {
                Long i = Long.parseLong(s.substring(start, end));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkExponent(int eIndex, String s) {
        if (eIndex == s.length() - 1) {
            return false;
        }
        try {
            Long i = Long.parseLong(s.substring(eIndex+1));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isNumber(String s) {
        boolean containsE = false;
        int eIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                if (s.charAt(i) != 'e' && s.charAt(i) != 'E') {
                    return false;
                } else {
                    eIndex = i;
                    if (containsE) {
                        return false;
                    }
                    containsE = !containsE;
                }
            }
        }
        if (containsE) {
            return checkNumberOrDecimal(0, eIndex, s) && checkExponent(eIndex, s);
        } else {
            return checkNumberOrDecimal(0, s.length(), s);
        }
    }
}