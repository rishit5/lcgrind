class Solution {
    private int timeTaken(int[] piles, int speed) {
        int totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            double pile = piles[i];
            double spp = speed;
            totalTime += Math.ceil(pile / spp);
        }
        return totalTime;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // System.out.println(timeTaken(piles, mid) + " " + mid);
            if (timeTaken(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}