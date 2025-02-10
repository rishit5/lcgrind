class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> countMap = new HashMap<>();
        // i, j, k
        int n = nums.length;
        int ans = 0;
        for (int k = 2; k < n; k++) {
            int prev = nums[k-1] % d; // j
            for (int i = k-2; i >= 0; i--) {
                int value = (nums[i] + prev) % d;
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }
            int value = nums[k] % d;
            if (value == 0) {
                ans += countMap.getOrDefault(0, 0);
            } else {
                ans += countMap.getOrDefault(d - value, 0);
            }
        }
        return ans;
    }
}