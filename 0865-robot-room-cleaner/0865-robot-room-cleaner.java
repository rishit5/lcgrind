/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Robot robot;
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();

    private void goBack() {
        this.robot.turnRight();
        this.robot.turnRight();
        this.robot.move();
        this.robot.turnRight();
        this.robot.turnRight();
    }

    private void backtrack(int x, int y, int d) {
        this.visited.add(new Pair(x, y));
        this.robot.clean();

        for (int i = 0; i < 4; i++) {
            int newDir = (d + i) % 4;
            int newDirX = x + directions[newDir][0];
            int newDirY = y + directions[newDir][1];

            if (!this.visited.contains(new Pair(newDirX, newDirY)) && this.robot.move()) {
                backtrack(newDirX, newDirY, newDir);
                this.goBack();
            }

            this.robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}