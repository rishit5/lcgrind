class Solution:
    def __init__(self):
        self.result = []

    def dfs(self, curr, candidates, target, currSum, currList):
        if currSum > target:
            return
        if currSum == target:
            res = currList.copy()
            self.result.append(res)
            return
        for i in range(curr+1, len(candidates)):
            if i > curr + 1 and candidates[i-1] == candidates[i]:
                continue
            currList.append(candidates[i])
            self.dfs(i, candidates, target, currSum + candidates[i], currList)
            currList.pop()
        return

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        for i in range(len(candidates)):
            if i > 0 and candidates[i-1] == candidates[i]:
                continue 
            self.dfs(i, candidates, target, candidates[i], [candidates[i]])
        return self.result