class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        stack = []
        stack.append(0)
        for i in range(1, len(prices)):
            while len(stack) > 0 and prices[stack[-1]] >= prices[i]:
                top = stack.pop()
                prices[top] -= prices[i]
            stack.append(i)
        return prices
            