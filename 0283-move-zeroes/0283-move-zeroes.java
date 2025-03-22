class Solution {
    public void moveZeroes(int[] nums) {
        int curr = 0;
        int toRe = 0;
        while (curr < nums.length) {
            if (nums[curr] != 0) {
                nums[toRe] = nums[curr];
                toRe += 1;
            }
            curr += 1;
        }
        while (toRe < nums.length) {
            nums[toRe] = 0;
            toRe += 1;
        }
    }
}