import numpy as np

class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        np_array = np.array(matrix)
        maxes = []
        result = []
        for i in range(len(matrix[0])):
            maxes.append(max(np_array[:,i]))
        for i in range(len(matrix)):
            max_row = min(matrix[i])
            if maxes[matrix[i].index(max_row)] == max_row:
                result.append(max_row)
        return result