class Solution:
    def __init__(self):
        self.result = []

    def dfs(self, curr, candidates, target, currSum, currList):
        print(currSum, currList)
        if currSum > target:
            return
        if currSum == target:
            res = currList.copy()
            self.result.append(res)
            return
        for i in range(curr, len(candidates)):
            currList.append(candidates[i])
            self.dfs(i, candidates, target, currSum + candidates[i], currList)
            currList.pop()
        return

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.dfs(0, candidates, target, 0, [])
        return self.result