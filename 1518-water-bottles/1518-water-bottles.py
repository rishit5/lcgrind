class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        bottles = numBottles
        drank_ret = 0
        while bottles >= numExchange:
            drank_ret = drank_ret + int(bottles/numExchange)
            bottles = int(bottles / numExchange) + (bottles % numExchange)
        return drank_ret + numBottles