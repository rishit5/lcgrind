class Solution {
    
    public int sum_hor(int[][] grid, int i, int j) {
        return grid[i][j] + grid[i][j+1] + grid[i][j+2];
    }
    
    public int sum_ver(int[][] grid, int i, int j) {
        return grid[i][j] + grid[i+1][j] + grid[i+2][j];
    }
    
    public int sum_diag(int[][] grid, int i, int j, int k) {
        if (k == 1) {
            return grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
        } else {
            return grid[i][j] + grid[i+1][j-1] + grid[i+2][j-2];   
        }
    }
    
    public boolean countPresent(int[][] grid, int i, int j) {
        int[] counter = new int[16];
        
        Arrays.fill(counter, 0);
        
        counter[grid[i+0][j+0]] += 1;
        counter[grid[i+0][j+1]] += 1;
        counter[grid[i+0][j+2]] += 1;
        
        counter[grid[i+1][j+0]] += 1;
        counter[grid[i+1][j+1]] += 1;
        counter[grid[i+1][j+2]] += 1;
        
        counter[grid[i+2][j+0]] += 1;
        counter[grid[i+2][j+1]] += 1;
        counter[grid[i+2][j+2]] += 1;
        
        for (int k = 1; k < 10; k++) {
            if (counter[k] == 0 || counter[k] >= 2) {
                return false;
            }
        }
        return true;
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (j + 2 < grid[i].length && i + 2 < grid.length) {
                    // System.out.println(i + " " + j);
                    if (sum_hor(grid, i, j) == 15 && sum_hor(grid, i+1, j) == 15 && sum_hor(grid, i+2, j) == 15 
                       && sum_ver(grid, i, j) == 15 && sum_ver(grid, i, j+1) == 15 && sum_ver(grid, i, j+2) == 15 && sum_diag(grid, i, j, 1) == 15 && sum_diag(grid, i, j+2, 0) == 15
                       && countPresent(grid, i, j)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}