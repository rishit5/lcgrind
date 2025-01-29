class Solution:
    def __init__(self):
        self.result = []
    
    def dfs(self, curr, n, candidates, currList):
        if n % candidates[curr] == 0:
            currList.append(candidates[curr])
            currList.append(int(n / candidates[curr]))
            self.result.append(currList.copy())
            currList.pop()
            newCandidates = [x for x in range(candidates[curr], floor(sqrt(n / candidates[curr]))+1)]
            for i in range(len(newCandidates)):
                self.dfs(i, int(n / candidates[curr]), newCandidates, currList)
            currList.pop()

    def getFactors(self, n: int) -> List[List[int]]:
        candidates = [x for x in range(2, floor(sqrt(n))+1)]
        for i in range(len(candidates)):
            self.dfs(i, n, candidates, [])
        return self.result