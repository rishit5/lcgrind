class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // if (s1.equals(s2)) {
        //     return true;
        // }
        int i1 = 0, i2 = 0;
        int counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                i1 = i2;
                i2 = i;
            } else {
                counter += 1;
            }
        }
        System.out.println(i1 + " " + i2 + " " + counter);
        if (counter == s1.length()) {
            return true;
        }
        if (counter == s1.length() - 2) {
            if (s1.charAt(i1) == s2.charAt(i2) && s2.charAt(i1) == s1.charAt(i2)) {
                return true;
            }
        }
        return false;
    }
}