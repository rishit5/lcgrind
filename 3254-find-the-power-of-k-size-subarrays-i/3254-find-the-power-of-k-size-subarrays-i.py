class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        if len(nums) == 0:
            return []
        elif k == 1:
            return nums
        cont = 1
        result = []
        for i in range(1, len(nums)):
            if nums[i] - 1 == nums[i-1]:
                cont += 1
            else:
                cont = 1
            if i >= k-1:
                if cont >= k:
                    result.append(nums[i])
                else:
                    result.append(-1)
        return result