class Solution {
    public boolean isPerfectSquare(int num) {
        long left  = 1;
        long right = num;
        long numLong = (long) num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > numLong) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}