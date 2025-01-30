class Solution:
    def __init__(self):
        self.result = []

    def branch(self, i, nums):
        if i == len(nums):
            self.result.append(nums.copy())
            return
        for j in range(i, len(nums)):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            # self.result.append(nums.copy())
            self.branch(i+1, nums)
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

    def permute(self, nums: List[int]) -> List[List[int]]:
        # for i in range(len(nums)):
        self.branch(0, nums)
        # self.result.append(nums.copy())
        return self.result
