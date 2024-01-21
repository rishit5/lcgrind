class Solution {
    public int rob(int[] nums) {
        int[] dps = new int[nums.length];

        dps[0] = nums[0];

        if (nums.length >= 2) {
            dps[1] = Math.max(dps[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dps[i] = Math.max(dps[i-1], dps[i-2] + nums[i]);
        }

        return dps[nums.length - 1];
    }
}