class Solution {
    public boolean isRobotBounded(String instructions) {
        // N E S W
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0;
        int y = 0;
        int idx = 0;

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                idx = (idx + 3) % 4;
            } else if (instructions.charAt(i) == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        return (x == 0 && y == 0) || (idx != 0);
    }
}