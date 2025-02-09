class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;

        int rightMost = -1;
        int leftMost  = -1;

        // Find the left most occurence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftMost = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left  = 0;
        right = nums.length - 1;


        // Find the right most occurence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rightMost = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{leftMost, rightMost};
    }
}