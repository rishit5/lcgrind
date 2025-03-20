class Solution {
    
    private int computeGCD(int x, int y) {
        int large = x >= y ? x : y;
        int small = x <  y ? x : y;
        if (large % small == 0) {
            return small;
        } else {
            return computeGCD(large % small, small);
        }
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int gc = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gc = computeGCD(gc, numsDivide[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > gc) {
                return -1;
            } else {
                if (gc % nums[i] == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}