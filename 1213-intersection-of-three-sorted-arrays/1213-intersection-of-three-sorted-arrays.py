class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        i = 0
        j = 0
        k = 0
        result = []
        while i < len(arr1) and j < len(arr2) and k < len(arr3):
            if arr1[i] == arr2[j] == arr3[k]:
                result.append(arr1[i])
                i += 1
                j += 1
                k += 1
            else:
                max_ = max(arr1[i], arr2[j], arr3[k])
                while i < len(arr1) and arr1[i] < max_:
                    i += 1
                while j < len(arr2) and arr2[j] < max_:
                    j += 1
                while k < len(arr3) and arr3[k] < max_:
                    k += 1
        return result