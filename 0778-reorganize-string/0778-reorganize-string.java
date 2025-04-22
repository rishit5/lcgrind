class Solution {
    public String reorganizeString(String s) {
        int[] sCharArray = new int[26];
        int maxCount = Integer.MIN_VALUE;
        int maxLetter = -1;
        for (int i = 0; i < s.length(); i++) {
            sCharArray[s.charAt(i) - 'a'] += 1;
            if (sCharArray[s.charAt(i) - 'a'] > maxCount) {
                maxCount = sCharArray[s.charAt(i) - 'a'];
                maxLetter = s.charAt(i) - 'a';
            }
        }
        System.out.println(maxCount);
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        int i = 0;
        char[] result = new char[s.length()];
        while (i < s.length() && sCharArray[maxLetter] > 0) {
            result[i] = (char) (maxLetter + 'a');
            sCharArray[maxLetter] -= 1;
            i += 2;
        }
        for (int j = 0; j < 26; j++) {
            while (sCharArray[j] > 0) {
                if (i >= s.length()) {
                    i = 1;
                }
                result[i] = (char) (j + 'a');
                sCharArray[j] -= 1;
                i += 2;
            }
        }
        return new String(result);
    }
}