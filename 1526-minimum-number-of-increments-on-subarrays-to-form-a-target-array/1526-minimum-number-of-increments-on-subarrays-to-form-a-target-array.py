class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        result = target[0]
        operationsWeCanReuse = target[0]
        for i in range(len(target)):
            if i != len(target) - 1:
                if target[i] >= target[i+1]:
                    operationsWeCanReuse = target[i+1]
                else:
                    result += (target[i+1] - operationsWeCanReuse)
                    operationsWeCanReuse = target[i+1]
            else:
                if operationsWeCanReuse < target[i]:
                    result += (target[i] - operationsWeCanReuse)
            # print(f"Result is {result} and operationsWeCanResuse are {operationsWeCanReuse}")
        return result
        