class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid.length];
        
        for (int i = 0; i < grid.length; i++) {
            dp[0][i] = grid[0][i];
        }
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // if (j == 0) {
                //     dp[i][j] = grid[i][j] + dp[i-1][j+1];
                // } else if (j == grid.length - 1) {
                //     dp[i][j] = grid[i][j] + dp[i-1][j-1];
                // } else {
                //     dp[i][j] = grid[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j+1]);
                // }
                int minSoFar = 99999999;
                for (int k = 0; k < grid.length; k++) {
                    if (k == j) {
                        continue;
                    } else {
                        if (dp[i-1][k] < minSoFar) {
                            minSoFar = dp[i-1][k];
                        }
                    }
                }
                dp[i][j] = grid[i][j] + minSoFar;
            }
        }
        
        int maxSoFar = 9999999;
        for (int i = 0; i < grid.length; i++) {
            if (dp[grid.length-1][i] < maxSoFar) {
                maxSoFar = dp[grid.length-1][i];
            }
        }
        
        return maxSoFar;
    }
}