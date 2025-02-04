class Solution {
    public int maxAscendingSum(int[] nums) {
        int currSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }
            max = Math.max(currSum, max);
        }
        return max;
    }
}