class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        i = 0
        j = sum(nums) - 1
        count = 0
        while i <= j:
            if nums[i] == 0:
                count += 1
            i += 1
        min_so_far = count
        print(count)
        i = 1
        j = sum(nums) - 1
        while i < len(nums):
            if j + 1 == len(nums):
                j = 0
            else:
                j = j + 1
            if nums[i-1] == 0:
                count = count - 1
            if nums[j] == 0:
                count = count + 1
            if count < min_so_far:
                min_so_far = count
            i += 1
        return min_so_far
        
        