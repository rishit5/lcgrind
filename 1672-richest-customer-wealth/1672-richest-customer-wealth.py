class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max_ = float('-inf')
        for i in accounts:
            sum_ = 0
            for j in i:
                sum_ += j
            if sum_ > max_:
                max_ = sum_
        return max_