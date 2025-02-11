class Solution {
    
    private int dfs(int[][] grid, int[][] visited, int i, int j) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair(i, j));
        int count = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> curr = stack.pop();
            int sr = curr.getKey();
            int sc = curr.getValue();
            if (visited[sr][sc] == 1) continue;
            visited[sr][sc] = 1;
            if (sr != 0) {
                if (grid[sr-1][sc] == 1 && visited[sr-1][sc] == 0) {
                    stack.push(new Pair(sr-1, sc));
                }
            }
            if (sr != grid.length - 1) { 
                if (grid[sr+1][sc] == 1 && visited[sr+1][sc] == 0) {
                    stack.push(new Pair(sr+1, sc));
                }
            }
            if (sc != 0) {
                if (grid[sr][sc-1] == 1 && visited[sr][sc-1] == 0) {
                    stack.push(new Pair(sr, sc-1));
                }
            }
            if (sc != grid[0].length - 1) {
                if (grid[sr][sc+1] == 1 && visited[sr][sc+1] == 0) {
                    stack.push(new Pair(sr, sc+1));
                }
            }
            count++;
        }
        return count;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int currMax = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    currMax = Math.max(currMax, dfs(grid, visited, i, j));
                }
            }
        }
        return currMax;
    }
}