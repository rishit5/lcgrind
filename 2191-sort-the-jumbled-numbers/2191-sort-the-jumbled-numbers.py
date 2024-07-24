class Pair:
    def __init__(self, nums, maps, index):
        self.nums = nums
        self.maps = maps
        self.index = index

class Solution:
    def convert(self, list_nums, mapping):
        j = 1
        sum_ = 0
        for i in range(len(list_nums)):
            sum_ = sum_ + mapping[int(list_nums[len(list_nums) - 1 - i])] * j
            j = j * 10
        return sum_

    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        final_result = []
        result = []
        for i, num in enumerate(nums):
            converted_val = self.convert(list(str(num)), mapping)
            result.append(Pair(num, converted_val, i))
        sorted_result = sorted(result, key=lambda pair: (pair.maps, pair.index))
        for resu in sorted_result:
            final_result.append(resu.nums)
        return final_result