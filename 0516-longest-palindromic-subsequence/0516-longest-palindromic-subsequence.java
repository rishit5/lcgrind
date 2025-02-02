class Solution {
    public int longestPalindromeSubseq(String s) {
        String srev = "";
        for (int i = 0; i < s.length(); i++) {
            srev += s.charAt(s.length() - i - 1);
        }

        String text1 = s;
        String text2 = srev;

        int[][] dp = new int[text2.length() + 1][text1.length() + 1];

        for (int i = text2.length() - 1; i >= 0; i--) {
            for (int j = text1.length() - 1; j >= 0; j--) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j+1], Math.max(dp[i+1][j], dp[i][j+1]));
                }
            }
        }

        return dp[0][0];
    }
}