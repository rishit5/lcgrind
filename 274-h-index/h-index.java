class Solution {
    public int hIndex(int[] citations) {
        // [1, 3, 1]
        // [1, 1, 3]
        // [3, 2, 1]
        int result = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (n - i <= citations[i]) {
                return n - i;
            }
        }
        return 0;
    }
}