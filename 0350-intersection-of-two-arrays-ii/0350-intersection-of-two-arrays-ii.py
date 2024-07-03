class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        dict1 = {}
        dict2 = {}
        for num1 in nums1:
            if num1 in dict1:
                dict1[num1] = dict1[num1] + 1
            else:
                dict1[num1] = 1
        for num2 in nums2:
            if num2 in dict2:
                dict2[num2] = dict2[num2] + 1
            else:
                dict2[num2] = 1
        result = []
        for key1 in dict1.keys():
            if key1 in dict2:
                times = min(dict1[key1], dict2[key1])
                for i in range(times):
                    result.append(key1)
        return result
                