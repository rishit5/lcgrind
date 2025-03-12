class Solution {

    private int[] dp = new int[50001];

    private int findNextIndex(int[] startTime, int curr) {
        int start = 0;
        int end = startTime.length - 1;
        int nextIndex = startTime.length;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (startTime[mid] >= curr) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nextIndex;
    }

    private int findMax(List<List<Integer>> jobs, int[] startTime, int curr) {
        if (curr == jobs.size()) {
            return 0;
        }
        if (dp[curr] != -1) {
            return dp[curr];
        }
        int nextIndex = findNextIndex(startTime, jobs.get(curr).get(1));

        int maxProfit = Math.max(findMax(jobs, startTime, curr+1), 
                        jobs.get(curr).get(2) + findMax(jobs, startTime, nextIndex));
        
        dp[curr] = maxProfit;

        return maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        Arrays.fill(dp, -1);
        for (int i = 0; i < profit.length; i++) {
            List<Integer> currList = new ArrayList<>();
            currList.add(startTime[i]);
            currList.add(endTime[i]);
            currList.add(profit[i]);
            jobs.add(currList);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        for (int i = 0; i < jobs.size(); i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        return findMax(jobs, startTime, 0);
    }
}