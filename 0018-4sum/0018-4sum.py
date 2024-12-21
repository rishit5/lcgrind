class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        result = set()
        nums.sort()
        for i in range(len(nums)):
            for j in range(i+1, len(nums), 1):
                start = j + 1
                end = len(nums) - 1
                while start < end:
                    if nums[i] + nums[j] + nums[start] + nums[end] == target:
                        result.add("_".join([str(nums[i]), str(nums[j]), str(nums[start]), str(nums[end])]))
                        start += 1
                        end -= 1
                    elif nums[i] + nums[j] + nums[start] + nums[end] < target:
                        start += 1
                    else:
                        end -= 1
        result_ = []
        for i in list(result):
            result_.append([int(x) for x in i.split("_")])
        return result_