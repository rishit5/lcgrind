class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int current = 0;
        while (current < nums.length) {
            map.putIfAbsent(nums[current], 0);
            map.put(nums[current], map.get(nums[current]) + 1);
            if (map.get(nums[current]) > 2) {
                current += 1;
            } else {
                nums[start] = nums[current];
                start += 1;
                current += 1;
            }
        }
        return start;
    }
}