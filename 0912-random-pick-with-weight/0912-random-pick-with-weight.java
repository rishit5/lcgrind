class Solution {

    double[] distribution;
    int[] nums;

    public Solution(int[] w) {
        distribution = new double[w.length];
        nums = new int[w.length];
        double sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            nums[i] = w[i];
        }

        for (int i = 0; i < w.length; i++) {
            distribution[i] = ((double) w[i]) / sum;
        }

        for (int i = 1; i < w.length; i++) {
            distribution[i] += distribution[i-1];
        }

    }
    
    public int pickIndex() {
        Random random = new Random();
        double prob = random.nextDouble();
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (distribution[mid] > prob) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */