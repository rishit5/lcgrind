class Solution:
    def countPairs(self, nums: List[int], lower: int) -> int:
        nums.sort()
        result = 0
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] < lower:
                    result += 1
                elif nums[i] + nums[j] >= lower:
                    break
        return result