class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 4:
            return 0;
        nums.sort()
        minSoFar = 9999999999
        if nums[-4] - nums[0] < minSoFar:
            minSoFar = nums[-4] - nums[0]
        if nums[-1] - nums[3] < minSoFar:
            minSoFar = nums[-1] - nums[3]
        if nums[-3] - nums[1] < minSoFar:
            minSoFar = nums[-3] - nums[1]
        if nums[-2] - nums[2] < minSoFar:
            minSoFar = nums[-2] - nums[2]
        return minSoFar
        