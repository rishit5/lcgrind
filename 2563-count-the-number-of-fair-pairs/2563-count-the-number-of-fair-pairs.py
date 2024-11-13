class Solution:
    
    def result(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        res = 0
        while left < right:
            if nums[left] + nums[right] < target:
                res += left - right
                left += 1
            else:
                right -= 1
        return res
    
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        return -(self.result(nums, upper+1) - self.result(nums, lower))
        