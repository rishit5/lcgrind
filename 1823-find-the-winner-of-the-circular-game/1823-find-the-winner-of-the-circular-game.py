class ListNode:
    def __init__(self, val, nextNode=None):
        self.val = val;
        self.nextNode = nextNode

class Solution:
    def createNSizeNode(self, size):
        first = ListNode(1)
        first.nextNode = first
        curr = first
        back = first
        for i in range(2, size+1):
            curr.nextNode = ListNode(i, back)
            curr = curr.nextNode
        return first
    
    def simulate(self, ll, n, k):
        if ll.nextNode == ll:
            return ll.val
        back = ll
        for i in range(k-1):
            back = ll
            ll = ll.nextNode
        back.nextNode = ll.nextNode
        return self.simulate(ll.nextNode, n, k)
            
            
    def findTheWinner(self, n: int, k: int) -> int:
        if k == 1:
            return n
        ll = self.createNSizeNode(n)
        return self.simulate(ll, n, k)