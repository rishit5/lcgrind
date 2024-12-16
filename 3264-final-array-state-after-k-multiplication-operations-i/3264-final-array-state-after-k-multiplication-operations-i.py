class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        sorted_nums = [(val, i) for i, val in enumerate(nums)]
        heapq.heapify(sorted_nums)
        for i in range(k):
            val, index = heapq.heappop(sorted_nums)
            nums[index] *= multiplier
            heapq.heappush(sorted_nums, (nums[index], index))
        return nums