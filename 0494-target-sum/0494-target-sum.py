class Solution:
    def backtrack(self, curr: int, nums: List[int], target: int, result: int) -> int:
        if (curr, result) in self.memo:
            return self.memo[(curr, result)]
        if curr == len(nums):
            if result == target:
                return 1
            else:
                return 0
        else:
            positive = self.backtrack(curr+1, nums, target, result + nums[curr]) 
            negative = self.backtrack(curr+1, nums, target, result - nums[curr])
            self.memo[(curr, result)] = positive + negative
            return self.memo[(curr, result)]

    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        self.memo = dict()
        return self.backtrack(0, nums, target, 0)