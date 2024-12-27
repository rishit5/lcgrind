class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] values1 = values.clone();
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < values1.length; i++) {
            values1[i] = Math.max(values1[i-1], values[i] + i);
            result = Math.max(result, values1[i-1] + values[i] - i);
        }
        return result;
    }
}