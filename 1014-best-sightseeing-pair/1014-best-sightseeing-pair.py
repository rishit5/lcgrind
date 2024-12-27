class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        max_ = float('-inf')
        dp = values.copy()
        for i in range(1, len(dp)):
            dp[i] = max(dp[i-1], dp[i]+i)
            max_ = max(max_, values[i] - i + dp[i-1])
        return max_