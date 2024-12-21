class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        if len(nums) < 3:
            return -1
        closest_ = float('inf')
        result = None
        for i, n in enumerate(nums):
            start = i + 1
            end = len(nums) - 1
            while start < end and start > i and end < len(nums):
                if abs(target - (nums[start] + nums[end] + n)) < closest_:
                    closest_ = abs(target - (nums[start] + nums[end] + n))
                    result = nums[start] + nums[end] + n
                if target - n > nums[start] + nums[end]:
                    start += 1
                else:
                    end -= 1
            if closest_ == 0:
                break
        return result