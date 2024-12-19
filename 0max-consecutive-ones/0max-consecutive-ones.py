class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        sum_ = 0
        max_ = float('-inf')
        for i, n in enumerate(nums):
            if n == 1:
                sum_ += 1
            else:
                sum_ = 0
            if sum_ > max_:
                max_ = sum_
        return max_