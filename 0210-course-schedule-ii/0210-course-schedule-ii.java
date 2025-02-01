class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.putIfAbsent(prerequisites[i][1], new LinkedList<Integer>());
            adjList.get(prerequisites[i][1]).addLast(prerequisites[i][0]);
            inDegree[prerequisites[i][0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            LinkedList<Integer> adjListCurr = adjList.getOrDefault(curr, new LinkedList<>());
            for (Integer neigh : adjListCurr) {
                inDegree[neigh] -= 1;
                if (inDegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
            result[i] = curr;
            i += 1;
        }
        if (i != numCourses) {
            return new int[]{};
        }
        return result;
    }
}