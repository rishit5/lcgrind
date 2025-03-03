class Solution {
    public int minCapability(int[] nums, int k) {
        int minReward = 1;
        int maxReward = Arrays.stream(nums).max().getAsInt();

        while (minReward < maxReward) {
            int midReward = minReward + ((maxReward - minReward) / 2);
            int totalCount = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= midReward) {
                    totalCount += 1;
                    i += 1;
                }
            }

            if (totalCount >= k) {
                maxReward = midReward;
            } else {
                minReward = midReward + 1;
            }
        }

        return minReward;
    }
}