class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (n == 0) {
                return true;
            } else {
                if (flowerbed[0] == 0 && n == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        int maxFlowers = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    maxFlowers += 1;
                } else {
                    continue;
                }
            } else if (i == flowerbed.length - 1) {
                if (i - 1 >= 0 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                    flowerbed[i] = 1;
                    maxFlowers += 1;
                } else {
                    continue;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    maxFlowers += 1;
                } else {
                    continue;
                }
            }
        }

        if (maxFlowers >= n) {
            return true;
        }
        return false;
    }
}