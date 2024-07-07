class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        jumps = n - 1
        if int(time / jumps) % 2 != 0:
            return (jumps - (time % jumps)) + 1
        else:
            return (time % jumps) + 1