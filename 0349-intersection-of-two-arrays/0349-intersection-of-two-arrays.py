class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        i1 = 0
        i2 = 0
        result = set()
        nums1.sort()
        nums2.sort()
        while i1 < len(nums1) and i2 < len(nums2):
            if nums1[i1] == nums2[i2]:
                result.add(nums1[i1])
                i1 += 1
                i2 += 1
            elif nums1[i1] > nums2[i2]:
                i2 += 1
            else:
                i1 += 1
        return list(result)