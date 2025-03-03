class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i - 2 >= 0) {
                dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
            } else if (i - 1 >= 0) {
                dp[i] = Math.max(dp[i-1], nums[i]);
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}