class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (j == 0 && wordSet.contains(sub)) {
                    dp[i-1] = true;
                    break;
                } else if (j >= 1 && dp[j-1] && wordSet.contains(sub)) {
                    dp[i-1] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}