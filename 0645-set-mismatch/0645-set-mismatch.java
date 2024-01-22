class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int rep = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                rep = nums[i];
            } else {
                set.add(nums[i]);
            }
            sum += nums[i];
        }
        int total = (nums.length * (nums.length + 1)) / 2;
        int[] resu = new int[2];
        if (sum > total) {
            resu[0] = rep;
            resu[1] = rep - (sum - total);
        } else {
            resu[0] = rep;
            resu[1] = rep + (total-sum);
        }
        return resu;
    }
}