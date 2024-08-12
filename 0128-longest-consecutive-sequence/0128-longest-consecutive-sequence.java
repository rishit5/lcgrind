class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setNums = new HashSet<>();

        for (int num : nums) {
            setNums.add(num);
        }

        int maxSo = 0;

        for (int num : setNums) {
            int length = 1;
            if (!setNums.contains(num-1)) {
                while (setNums.contains(num+length)) {
                    length++;
                }
                maxSo = Math.max(maxSo, length);
            }
        }

        return maxSo;
    }
}
