class Solution:
    def __init__(self):
        self.result = []

    def branch(self, i, nums):
        if i == len(nums):
            self.result.append(nums.copy())
            return

        set_ = set()

        for j in range(i, len(nums)):
            if nums[j] in set_:
                continue
            nums[i], nums[j] = nums[j], nums[i]
            self.branch(i+1, nums)
            nums[i], nums[j] = nums[j], nums[i]
            set_.add(nums[j])

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        self.branch(0, nums)
        return self.result
