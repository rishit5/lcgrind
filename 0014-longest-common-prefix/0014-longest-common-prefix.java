class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int k = 0;
            int j = 0;
            if (prefix.equals("")) {
                return "";
            }
            for (j = 0; j < strs[i].length() && j < prefix.length(); j++) {
                if (strs[i].charAt(j) != prefix.charAt(k)) {
                    break;
                }
                k += 1;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}