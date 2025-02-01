class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean result = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i-1] % 2 == 0) {
                    return false;
                }
            }
            if (nums[i] % 2 == 1) {
                if (nums[i-1] % 2 == 1) {
                    return false;
                }
            }
        }
        return result;
    }
}