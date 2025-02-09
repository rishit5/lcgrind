class Solution {

    private List<List<Integer>> result;

    private void backTrack(int[] nums, int curr) {
        if (curr >= nums.length) {
            List<Integer> resultCurr = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                resultCurr.add(nums[i]);
            }
            this.result.add(resultCurr);
            return;
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = curr; i < nums.length; i++) {
            if (resultSet.contains(nums[i])) {
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[curr];
            nums[curr] = temp;
            this.backTrack(nums, curr+1);
            temp = nums[i];
            nums[i] = nums[curr];
            nums[curr] = temp;
            resultSet.add(nums[i]);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.result = new LinkedList<>();
        this.backTrack(nums, 0);
        return this.result;
    }
}