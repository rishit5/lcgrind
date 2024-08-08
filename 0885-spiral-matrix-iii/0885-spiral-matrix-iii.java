class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] results = new int[rows * cols][2];
        int counter = 0;
        
        int curr_dir = 0;
        int steps = 1;
        
        while (counter < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        results[counter][0] = rStart;
                        results[counter][1] = cStart;
                        counter++;
                    }
                    rStart += directions[curr_dir][0];
                    cStart += directions[curr_dir][1];
                }
                curr_dir = (curr_dir + 1) % 4;
            }
            steps++;
        }
        return results;
    }
}