class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        if (typed.length() < name.length()) {
            return false;
        }
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                if (i == 0) {
                    return false;
                } else {
                    while (j < typed.length() && typed.charAt(j) == typed.charAt(j-1)) {
                        j += 1;
                    }
                    if (j < typed.length() && name.charAt(i) != typed.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        // System.out.println(i);
        // System.out.println(j);
        while (j < typed.length()) {
            if (name.charAt(i-1) != typed.charAt(j)) {
                return false;
            }
            j += 1;
        }
        return (i == name.length());
    }
}