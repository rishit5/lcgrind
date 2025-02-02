class Solution {
    public boolean check(int[] nums) {
        int numDec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] > nums[0]) {
                    numDec += 1;
                }
            } else {
                if (nums[i] > nums[i+1]) {
                    numDec += 1;
                }
            }
        }
        if (numDec >= 2) {
            return false;
        } else { 
            return true;
        }
    }
}