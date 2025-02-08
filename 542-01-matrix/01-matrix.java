class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        dp[0][0] = mat.length * mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 0) {
                    if (j != 0) {
                        dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                    } else {
                        dp[i][j] = dp[i-1][j] + 1;
                    }
                } else {
                    if (j != 0) {
                        dp[i][j] = dp[i][j-1] + 1;
                    }
                }
            }
        }
        int n = mat.length - 1;
        int m = mat[0].length - 1;
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != n) {
                    if (j != m) {
                        dp[i][j] = Math.min(dp[i][j], 1 + Math.min(dp[i+1][j], dp[i][j+1]));
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                    }
                } else {
                    if (j != m) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    }
                }
            }
        }
        return dp;
    }
}