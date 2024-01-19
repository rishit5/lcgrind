class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = 1000000;
                if (j != 0) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j-1], dp[i][j]);
                }
                if (j != matrix[i].length - 1) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j+1], dp[i][j]);
                }
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j], dp[i][j]);
            }
        }
        
        int result = 1000000;
        
        for (int i = 0; i < dp[dp.length-1].length; i++) {
            result = Math.min(result, dp[dp.length-1][i]);
        }
        
        return result;
    }
}