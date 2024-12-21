class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        # [-1, 2, 1, -4]
        # [-4, -1, 1, 2] , target = 1
        # [-4, -1, 1, 2]
        nums.sort()
        if len(nums) < 3:
            return -1
        # print(nums)
        closest_ = float('inf')
        result = None
        for i, n in enumerate(nums):
            start = i + 1
            end = len(nums) - 1
            # print(f"I is {i} and {closest_}")
            # print(f"I is {clo}")
            while start < end and start > i and end < len(nums):
                if abs(target - (nums[start] + nums[end] + n)) < closest_:
                    closest_ = abs(target - (nums[start] + nums[end] + n))
                    result = nums[start] + nums[end] + n
                if target - n > nums[start] + nums[end]:
                    start += 1
                else:
                    end -= 1
        return result