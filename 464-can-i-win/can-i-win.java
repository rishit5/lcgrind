class Solution {
    
public boolean dfs(int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> dp, int key) {
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (desiredTotal <= 0) {
            return false;
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((key & (1 << i)) == 0) { // Check if the number i is available
                int newKey = key | (1 << i); // Mark i as used
                if (!dfs(maxChoosableInteger, desiredTotal - i, dp, newKey)) {
                    dp.put(key, true);
                    return true;
                }
            }
        }
        dp.put(key, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 1) {
            return true;
        }
        int maxSum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (maxSum < desiredTotal) {
            return false;
        }
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxSum == desiredTotal) {
            return maxChoosableInteger % 2 == 1;
        }
        Map<Integer, Boolean> dp = new HashMap<>();
        return dfs(maxChoosableInteger, desiredTotal, dp, 0);
    }
}