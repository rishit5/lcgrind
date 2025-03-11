class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> myMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double slope = calculateSlope(points[i], points[j]);
                myMap.put(slope, myMap.getOrDefault(slope, 0) + 1);
                max = Math.max(max, myMap.get(slope));
            }
        }
        return max + 1;
    }

    private Double calculateSlope(int[] p1, int[] p2) {
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];

        if (x1 == x2) {
            return Double.MAX_VALUE;
        } else if (y1 == y2) {
            return 0d;
        } else {
            return (double) (y2 - y1) / (double) (x2 - x1);
        }
    }
}