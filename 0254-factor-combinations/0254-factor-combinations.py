class Solution:
    def __init__(self):
        self.result = []
    
    def dfs(self, curr, n, candidates, currList):
        # print(n, candidates[curr], candidates, currList)
        if n % candidates[curr] == 0:
            currList.append(candidates[curr])
            currList.append(int(n / candidates[curr]))
            self.result.append(currList.copy())
            currList.pop()
            newCandidates = [x for x in range(candidates[curr], floor(sqrt(n / candidates[curr]))+1)]
            # print(newCandidates)
            for i in range(len(newCandidates)):
                self.dfs(i, int(n / candidates[curr]), newCandidates, currList)
            currList.pop()

    def getFactors(self, n: int) -> List[List[int]]:
        # if n == 32:
        #     return [[2,16],[4,8],[2,2,8],[2,4,4],[2,2,2,4],[2,2,2,2,2]]
        candidates = [x for x in range(2, floor(sqrt(n))+1)]
        for i in range(len(candidates)):
            self.dfs(i, n, candidates, [])
        return self.result