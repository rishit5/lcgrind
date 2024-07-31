class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length];
        dp[0] = books[0][1];
        for (int i = 1; i < books.length; i++) {
            int currWidth = books[i][0];
            int currHeight = books[i][1];
            dp[i] = dp[i-1] + currHeight;
            for (int j = i - 1; j >= 0; j--) {
                currWidth = currWidth + books[j][0];
                currHeight = Math.max(currHeight, books[j][1]);
                if (currWidth <= shelfWidth) {
                    if (j != 0) {
                        dp[i] = Math.min(dp[i], dp[j-1] + currHeight);
                    } else {
                        dp[i] = Math.min(dp[i], currHeight);
                    }
                } else {
                    break;
                }
            }
        }
        return dp[books.length - 1];
    }
}