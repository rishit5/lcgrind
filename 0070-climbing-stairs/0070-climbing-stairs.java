class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] counts = new int[n];
        counts[0] = 1;
        counts[1] = 2;
        for (int i = 2; i < n; i++) {
            counts[i] = counts[i-1] + counts[i-2];
        }
        return counts[n-1];
    }
}