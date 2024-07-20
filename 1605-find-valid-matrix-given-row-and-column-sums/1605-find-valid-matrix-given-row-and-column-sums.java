class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;
        while (i < rowSum.length && j < colSum.length) {
            result[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] = rowSum[i] - result[i][j];
            colSum[j] = colSum[j] - result[i][j];
            
            if (rowSum[i] == 0) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}