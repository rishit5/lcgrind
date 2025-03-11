class Solution {
    
    public boolean dfs(int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> dp, int key) {
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (desiredTotal <= 0) {
            return false;
        }
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((key & (1<<i)) == 0) && !dfs(maxChoosableInteger, desiredTotal - i - 1, dp, key|1<<i)) {
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int maxSum = ((maxChoosableInteger) * (maxChoosableInteger + 1)) / 2;
        if (desiredTotal > maxSum) {
            return false;
        }
        if (desiredTotal <= 1) {
            return true;
        }
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (desiredTotal == maxSum) {
            return (maxChoosableInteger % 2 == 1);
        }
        Map<Integer, Boolean> dp = new HashMap<>();
        return dfs(maxChoosableInteger, desiredTotal, dp, 0);    
    }
}