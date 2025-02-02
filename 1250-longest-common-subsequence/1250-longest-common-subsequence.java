class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text2.length() + 1][];
        for (int i = 0; i <= text2.length(); i++) {
            dp[i] = new int[text1.length() + 1];
            Arrays.fill(dp[i], 0);
        }

        for (int i = text2.length() - 1; i >= 0; i--) {
            for (int j = text1.length() - 1; j >= 0; j--) {
                int addOn = 0;
                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] =  Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[0][0];
    }
}