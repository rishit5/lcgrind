class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();  // Stores frequency of remainder sums
        int ans = 0;

        for (int i = 2; i < n; i++) {  // Fixing k as nums[i]
            int prev = nums[i - 1] % d;  // Remainder of nums[k-1]

            // Iterate over all possible nums[j] where j < k-1
            for (int j = i - 2; j >= 0; j--) {  
                int v = (nums[j] + prev) % d;  // Compute remainder sum of nums[j] and nums[k-1]
                map.put(v, map.getOrDefault(v, 0) + 1);  // Store count of sum mod d
            }

            // Check how many (i, j) pairs exist such that their sum complements nums[i] to be divisible by d
            int v = nums[i] % d;
            ans += (v == 0) ? map.getOrDefault(0, 0) : map.getOrDefault(d - v, 0);
        }
        return ans;
    }
}
