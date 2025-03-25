class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[colors.length()];
        int[][] dp = new int[colors.length()][26];

        // Build Adjacency List and inDegree Counter
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adjList.putIfAbsent(a, new LinkedList<>());
            adjList.get(a).add(b);
            inDegree[b] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodeSeen = 0;
        int result = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            nodeSeen += 1;
            dp[current][colors.charAt(current) - 'a'] += 1;
            result = Math.max(dp[current][colors.charAt(current) - 'a'], result);
            
            // if (visited.contains(current)) {
            //     continue;
            // }
            
            // visited.add(current);

            if (!adjList.containsKey(current)) {
                continue;
            }

            for (Integer neighBour : adjList.getOrDefault(current, new LinkedList<>())) {
                for (int i = 0; i < 26; i++) {
                    dp[neighBour][i] = Math.max(dp[neighBour][i], dp[current][i]);
                }
                inDegree[neighBour] -= 1;
                if (inDegree[neighBour] == 0) {
                    queue.offer(neighBour);
                }
            }
        }

        return nodeSeen < colors.length() ? -1 : result;
    }
}