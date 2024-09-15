class Solution {
    public int findTheLongestSubstring(String s) {
        int characterMap[] = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];
        for (int i = 0; i < 32; i++) mp[i] = -1;
        int prefixOr = 0;
        int longestSub = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixOr ^= characterMap[s.charAt(i) - 'a'];
            if (mp[prefixOr] == -1 && prefixOr != 0) mp[prefixOr] = i;
            longestSub = Math.max(longestSub, i - mp[prefixOr]);
        }
        return longestSub;
    }
}