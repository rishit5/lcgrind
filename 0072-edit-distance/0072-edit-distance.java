class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int i = word1.length(); i >= 0; i--) {
            dp[word2.length()][i] = word1.length() - i;
        }
        for (int i = word2.length(); i >= 0; i--) {
            dp[i][word1.length()] = word2.length() - i;
        }
        for (int i = word2.length() - 1; i >= 0; i--) {
            for (int j = word1.length() - 1; j >= 0; j--) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }
}