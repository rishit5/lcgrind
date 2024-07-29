class Solution {
    private int count = 0;

    public boolean isValid(int i, int j, char[][] grid, int[][] visited) {
        if (i < 0 || i >= visited.length) {
            return false;
        }
        if (j < 0 || j >= visited[0].length) {
            return false;
        }
        if (grid[i][j] == '1' && visited[i][j] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void countGrids(char[][] grid, int[][] visited, int i, int j) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(i, j));
        while (!q.isEmpty()) {
            List<Integer> curr = q.remove();
            int i_ = curr.get(0);
            int j_ = curr.get(1);
            if (this.isValid(i_, j_+1, grid, visited)) {
                q.add(List.of(i_, j_+1));
                visited[i_][j_+1] = 1;
            }
            if (this.isValid(i_, j_-1, grid, visited)) {
                q.add(List.of(i_, j_-1));
                visited[i_][j_-1] = 1;
            }
            if (this.isValid(i_+1, j_, grid, visited)) {
                q.add(List.of(i_+1, j_));
                visited[i_+1][j_] = 1;
            }
            if (this.isValid(i_-1, j_, grid, visited)) {
                q.add(List.of(i_-1, j_));
                visited[i_-1][j_] = 1;
            }
        }
        this.count = this.count + 1;
        return;
    }

    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    countGrids(grid, visited, i, j);
                }
            }
        }
        return count;
    }
}