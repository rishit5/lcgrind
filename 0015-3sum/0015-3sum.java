class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int k = nums.length - 1;
            while (j < k) {
                // System.out.println(i + ": " + j + " " + k);
                if (j == i) {
                    j++;
                    continue;
                } 
                if (k == i) {
                    k--;
                    continue;
                }
                int target = -nums[i];
                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        List<List<Integer>> results = new LinkedList<>();
        results.addAll(result);
        return results;
    }
}
