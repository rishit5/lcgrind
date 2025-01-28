class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array to optimize the binary search
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        int totalLength = m + n;
        
        while (low <= high) {
            int i = (low + high) / 2; // Partition point in nums1
            int j = (totalLength + 1) / 2 - i; // Corresponding partition point in nums2
            
            // Handle edge cases where partitions are at the boundaries
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // Correct partition found
                if (totalLength % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                // Move partition in nums1 to the left
                high = i - 1;
            } else {
                // Move partition in nums1 to the right
                low = i + 1;
            }
        }
        
        return 0.0; // This return is a fallback and should never be reached
    }
}