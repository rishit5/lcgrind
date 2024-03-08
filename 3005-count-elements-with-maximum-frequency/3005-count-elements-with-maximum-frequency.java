class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxSoFar = 0;
        
        for (int i = 0; i < nums.length; i++) {
            counts.putIfAbsent(nums[i], 0);
            counts.put(nums[i], counts.get(nums[i])+1);
            if (counts.get(nums[i]) > maxSoFar) {
                maxSoFar = counts.get(nums[i]);
            }
        }
        int result = 0;
        for (int i: counts.keySet()) {
            if (counts.get(i) == maxSoFar) {
                result += maxSoFar;
            }
        }
        return result;
    }
}