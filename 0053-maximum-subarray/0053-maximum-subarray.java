class Solution {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            runningSum = Math.max(runningSum+nums[i], nums[i]);
            result = Math.max(runningSum, result);
        }
        return result;
    }
}