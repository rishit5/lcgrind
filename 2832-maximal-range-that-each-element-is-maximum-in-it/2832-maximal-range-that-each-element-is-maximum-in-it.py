class Solution:
    def maximumLengthOfRanges(self, nums: List[int]) -> List[int]:
        # For finding the max on your left
        
        left_  = [0] * len(nums)
        stack = []
        
        for i in range(len(nums) - 1, -1, -1):
            n = nums[i]
            if len(stack) == 0:
                stack.append(i)
            else:
                top = stack[-1]
                if nums[top] > n:
                    stack.append(i)
                else:
                    while len(stack) > 0 and nums[stack[-1]] < n:
                        top = stack.pop()
                        left_[top] = i
                    stack.append(i)
        
        while len(stack) > 0:
            left_[stack.pop()] = -1
            
        right_ = [len(nums)-1] * len(nums)
        stack = []
        for i, n in enumerate(nums):
            if len(stack) == 0:
                stack.append(i)
            else:
                top = stack[-1]
                if nums[top] > n:
                    stack.append(i)
                else:
                    while len(stack) > 0 and nums[stack[-1]] < n:
                        top = stack.pop()
                        right_[top] = i
                    stack.append(i)
        while len(stack) > 0:
            right_[stack.pop()] = len(nums)
        for i in range(len(nums)):
            nums[i] = right_[i] - left_[i] - 1
        return nums
            
        