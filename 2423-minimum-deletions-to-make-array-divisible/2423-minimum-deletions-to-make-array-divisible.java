class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0];
        int tmp; 
        for (int a : numsDivide) {
            while (a > 0) {
                tmp = g % a;
                g = a;
                a = tmp;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= g; i++) {
            if (g % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}