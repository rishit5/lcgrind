class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZeros = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeros += 1;
            } else {
                product *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (countZeros >= 2) {
                nums[i] = 0;
            } else if (countZeros == 1) {
                if (nums[i] == 0) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = product / nums[i];
            }
        }

        return nums;
    }
}