class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] prefixSumLeft = new int[nums.length];
        int[] prefixSumRight = new int[nums.length];
        prefixSumLeft[0] = nums[0];
        prefixSumRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefixSumLeft[i] = nums[i] + prefixSumLeft[i-1];
            prefixSumRight[nums.length - i - 1] = nums[nums.length - i - 1] + prefixSumRight[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (prefixSumRight[i+1] == 0) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (prefixSumLeft[i-1] == 0) {
                    return i;
                }
            } else if (prefixSumLeft[i-1] == prefixSumRight[i+1]) {
                return i;
            }
        }
        return -1;
    }
}