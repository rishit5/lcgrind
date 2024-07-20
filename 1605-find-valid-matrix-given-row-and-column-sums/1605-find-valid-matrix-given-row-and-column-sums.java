class Solution {
    int[][] result;
    private int[] next(int i, int j, int rowSumLength, int colSumLength) {
        if (j+1 == colSumLength) {
            int[] result = {i+1, 0};
            return result;
        } else {
            int[] result = {i, j+1};
            return result;
        }
    }
    private boolean calculate(int[] rowSum, int[] colSum, int i, int j) {
        if (i == rowSum.length) {
            return true;
        } else {
            for (int k = 0; k < Math.min(rowSum[i], colSum[j]); k++) {
                result[i][j] = k;
                rowSum[i] = rowSum[i] - k;
                colSum[j] = colSum[j] - k;
                int[] lengths = next(i, j, rowSum.length, colSum.length);
                if (calculate(rowSum, colSum, lengths[0], lengths[1]) == true) {
                    return true;
                }
                result[i][j] = 0;
                rowSum[i] = rowSum[i] + k;
                colSum[j] = colSum[j] + k;
            }
        }
        return false;
    }
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                result[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] = rowSum[i] - result[i][j];
                colSum[j] = colSum[j] - result[i][j];
            }
        }
        return result;
    }
}