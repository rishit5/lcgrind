class Solution {


    private int[] max(int[] a, int[] b, int[] c) {
        // Compare first elements
        if (a[0] > b[0] || (a[0] == b[0] && a[1] > b[1])) {
            if (a[0] > c[0] || (a[0] == c[0] && a[1] > c[1])) {
                return a; // a is the largest
            }
        }
        if (b[0] > c[0] || (b[0] == c[0] && b[1] > c[1])) {
            return b; // b is the largest
        }
        return c; // c is the largest
    }

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<List<Integer>> right = new ArrayList<>();
        
        for (long i = 0; i <= n; i++) {
            right.add(new ArrayList<>());
        }
        
        for (int i = 0; i < conflictingPairs.length; i++) {
            right.get(Math.max(conflictingPairs[i][0], conflictingPairs[i][1]))
                .add(Math.min(conflictingPairs[i][0], conflictingPairs[i][1]));
        }

        long ans = 0;
        int[] left = new int[]{0, 0};
        long[] imp = new long[n+1];
        long maxSoFar = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j : right.get(i)) {
                left = max(left, new int[]{j, left[0]}, new int[]{left[0], j});
            }
            ans += i - left[0];
            imp[left[0]] += (long) left[0] - (long) left[1];
            if (maxSoFar < imp[left[0]]) {
                maxSoFar = imp[left[0]];
            }
        }

        return ans + maxSoFar;
    }
}