class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 4) {
            return 0;
        }
        double minSoFar = 9999999999d;
        if (nums[nums.length - 4] - nums[0] < minSoFar) {
            minSoFar = nums[nums.length - 4] - nums[0];
        } 
        if (nums[nums.length - 1] - nums[3] < minSoFar) {
            minSoFar = nums[nums.length - 1] - nums[3];
        } 
        if (nums[nums.length - 3] - nums[1] < minSoFar) {
            minSoFar = nums[nums.length - 3] - nums[1];
        } 
        if (nums[nums.length - 2] - nums[2] < minSoFar) {
            minSoFar = nums[nums.length - 2] - nums[2];
        } 
        return (int) minSoFar;
    }
}