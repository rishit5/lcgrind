class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        start  = 0
        end    = len(nums) - 1
        result = [0] * len(nums)
        for i in range(len(nums)):
            if abs(nums[start]) > abs(nums[end]):
                result[len(nums) - 1 - i] = nums[start] ** 2
                start += 1
            else:
                result[len(nums) - 1 - i] = nums[end] ** 2
                end -= 1
        return result