class Solution {
    public int findChampion(int n, int[][] edges) {
        // [0, 1, 2] [[0, 1], [1, 2]] => [1] => [1, 2]
        // {0:0, 1:0, 2:2, 3:1}
        // {0:0, 1:0, 3:1, 3:1}
        if (n == 1) {
            return 0;
        }
        if (edges.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Integer num : map.keySet()) {
            pq.add(new Pair(num, map.get(num)));
        }
        // System.out.println(map);
        // System.out.println(pq);
        if (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            Integer maxSo = pair.getValue();
            // System.out.println(pq);
            if (!pq.isEmpty()) {
                Pair<Integer, Integer> pair1 = pq.poll();
                Integer maxSo1 = pair1.getValue();
                if (maxSo1 == maxSo) {
                    return -1;
                } else {
                    return pair.getKey();
                }
            } else {
                return pair.getKey();
            }
        }
        return 0;
    }
}