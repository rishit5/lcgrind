class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int currProd = 1;
        int result = 0;
        if (k == 0 || k == 1) {
            return 0;
        }
        while (start < nums.length) {
            currProd *= nums[start];
            if (currProd < k) {
                result += start - end + 1;
            } else {
                while (currProd >= k && end <= start) {
                    currProd /= nums[end];
                    end += 1;
                }
                // if (end <= start) {
                    result += start - end + 1;
                // }
            }
            start += 1;
        }
        return result;
    }
}