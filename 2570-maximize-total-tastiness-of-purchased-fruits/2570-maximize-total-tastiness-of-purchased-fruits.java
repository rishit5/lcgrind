class Solution {
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        int[][] dp = new int[maxAmount+1][maxCoupons+1];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < price.length; i++) {
            for (int j = maxAmount; j >= 0; j--) {
                for (int k = maxCoupons; k >= 0; k--) {
                    if (j - price[i] >= 0) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - price[i]][k] + tastiness[i]);
                    }
                    if (k > 0) {
                        int couponCost = price[i] / 2;
                        if (j >= couponCost) {
                            dp[j][k] = Math.max(dp[j][k], dp[j - couponCost][k - 1] + tastiness[i]);
                        }
                    }
                    result = Math.max(result, dp[j][k]);
                }
            }
        }
        return result;
    }
}