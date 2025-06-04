class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        String result = "";
        boolean current = true;
        while (i < word1.length() || j < word2.length()) {
            if (current && i < word1.length()) {
                result += word1.charAt(i);
                i += 1;
            } else if (j < word2.length()) {
                result += word2.charAt(j);
                j += 1;
            }
            current = !current;
        }
        return result;
    }
}