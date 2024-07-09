class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        currentTime = customers[0][0] + customers[0][1]
        timeWaited = customers[0][1]
        for i in range(1, len(customers)):
            if customers[i][0] > currentTime:
                currentTime = customers[i][0] + customers[i][1]
                timeWaited = timeWaited + customers[i][1]
            else:
                timeWaited = timeWaited + (currentTime - customers[i][0]) + customers[i][1]
                currentTime = currentTime + customers[i][1]
        return timeWaited / len(customers)