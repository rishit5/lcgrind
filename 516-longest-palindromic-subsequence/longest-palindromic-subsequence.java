class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        char[] sArr = s.toCharArray();
        char[] sRev = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            sRev[i] = sArr[sArr.length - i - 1];
        }

        for (int i = sArr.length - 1; i >= 0; i--) {
            for (int j = sRev.length - 1; j >= 0; j--) { 
                if (sArr[i] == sRev[j]) {
                    dp[i][j] = Math.max(1 + dp[i+1][j+1], Math.max(dp[i][j+1], dp[i+1][j]));
                } else {
                    dp[i][j] = Math.max(dp[i+1][j+1], Math.max(dp[i][j+1], dp[i+1][j]));
                }
            }
        }

        return dp[0][0];
    }
}