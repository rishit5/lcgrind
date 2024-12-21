class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        set_ = set()
        start = 0
        for i, n in enumerate(nums):
            if n not in set_:
                nums[start] = n
                start += 1
                set_.add(n)
        return len(list(set_))