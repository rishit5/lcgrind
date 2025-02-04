class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});

        List<List<Integer>> result = new LinkedList<>();

        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        while (!pq.isEmpty() && k != 0) {
            int[] curr = pq.poll();
            if (visited.contains(new Pair(curr[1], curr[2]))) {
                continue;
            }
            visited.add(new Pair(curr[1], curr[2]));
            k--;
            List<Integer> currResult = new LinkedList<>();
            currResult.add(nums1[curr[1]]);
            currResult.add(nums2[curr[2]]);
            result.add(currResult);
            if (curr[1] < nums1.length-1) {
                pq.add(new int[]{nums1[curr[1]+1] + nums2[curr[2]], curr[1] + 1, curr[2]});
            }
            if (curr[2] < nums2.length-1) {
                pq.add(new int[]{nums1[curr[1]] + nums2[curr[2]+1], curr[1], curr[2] + 1});
            }
        }

        return result;
    }
}