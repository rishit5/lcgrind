class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        int result = 0;
        for (int i = k - 1; i < arr.length; i++) {
            if (i == k - 1) {
                if (sum[i] / k >= threshold) {
                    result += 1;
                }
            } else {
                if ((sum[i] - sum[i - k]) / k >= threshold) {
                    result += 1;
                }
            }
        }
        return result;
    }
}