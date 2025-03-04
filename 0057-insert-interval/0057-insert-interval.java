class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> currList = new LinkedList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            currList.add(intervals[i]);
            i += 1;
        }

        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i += 1;
        }
        currList.add(newInterval);

        while (i < n) {
            currList.add(intervals[i]);
            i += 1;
        }
        return currList.toArray(new int[currList.size()][]);
    }
}