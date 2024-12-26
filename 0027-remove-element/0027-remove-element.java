class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end   = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                if (nums[end] == val) {
                    end -= 1;
                } else {
                    int temp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = temp;
                }
            } else {
                start += 1;   
            }
        }
        // if (start == 0) return start;
        return start;
    }
}