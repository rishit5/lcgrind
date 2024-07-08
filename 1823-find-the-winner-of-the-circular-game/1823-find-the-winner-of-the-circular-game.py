class ListNode:
    def __init__(self, val, nextNode=None):
        self.val = val;
        self.nextNode = nextNode

class Solution:
    def printNode(slef, ll):
        first = ll
        second = first.nextNode
        print("Here we go")
        print(first.val)
        while second != first:
            print(second.val)
            second = second.nextNode

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
        # self.printNode(ll.nextNode)
        return self.simulate(ll.nextNode, n, k)
            
            
    def findTheWinner(self, n: int, k: int) -> int:
        if k == 1:
            return n
        ll = self.createNSizeNode(n)
        # self.printNode(ll)
        return self.simulate(ll, n, k)