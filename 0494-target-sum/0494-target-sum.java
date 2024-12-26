class Solution {
    private int backtracking(int[] nums, int target, int curr, int sum) {
        if (curr == nums.length) {
            if (sum == target) {
                return 1;
            }
        } else {
            return this.backtracking(nums, target, curr+1, sum+nums[curr]) + this.backtracking(nums, target, curr+1, sum - nums[curr]);
        }
        return 0;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return this.backtracking(nums, target, 0, 0);
    }
}