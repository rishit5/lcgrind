class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i]  = Math.max(nums[i], nums[i] + dp[i-1]);
        }
        
        int max_so_far = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max_so_far = Math.max(max_so_far, dp[i]);
        }
        
        return max_so_far;
    }
}