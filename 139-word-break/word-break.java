class Solution {
    int[] memo;
    private boolean backTrack(String s, int curr, Set<String> wordDict) {
        if (curr == s.length()) {
            return true;
        }
        if (this.memo[curr] != -1) {
            return this.memo[curr] == 1;
        }
        String currString = "";
        for (int i = curr; i < s.length(); i++) {
            currString += s.charAt(i);
            if (wordDict.contains(currString)) {
                this.memo[curr] = 1;
                if (this.backTrack(s, i + 1, wordDict)) {
                    return true;
                }
            }
        }
        this.memo[curr] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new int[s.length()];
        Arrays.fill(this.memo, -1);
        return backTrack(s, 0, new HashSet<>(wordDict));
    }
}