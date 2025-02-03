class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 0;
        int decreasing = 0;
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                decreasing += 1;
                increasing = 0;
            } else if (nums[i] < nums[i+1]) {
                decreasing = 0;
                increasing += 1;
            } else {
                increasing = 0;
                decreasing = 0;
            }
            result = Math.max(result, Math.max(increasing, decreasing));
        }
        return result + 1;
    }
}