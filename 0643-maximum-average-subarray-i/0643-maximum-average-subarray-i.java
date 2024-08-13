class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int runSum = 0;
        
        for (int i = 0; i < k; i++) {
            runSum += nums[i];
        }
        
        int maxSoFar = runSum;
        
        for (int i = k; i < nums.length; i++) {
            runSum -= nums[i-k];
            runSum += nums[i];
            maxSoFar = Math.max(maxSoFar, runSum);
        }
        double result = ((double) maxSoFar) / k;
        return result;
    }
}