class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int o = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int currRes = 0;
            for (int i = start; i <= end; i++) {
                currRes ^= arr[i];
            }
            result[o++] = currRes;
        }
        return result;
    }
}