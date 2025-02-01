# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findOne(self, root, x):
        if root == None:
            return None
        if root.val == x.val:
            return root
        findLeft = self.findOne(root.left, x)
        findRight = self.findOne(root.right, x)
        if findLeft != None:
            return findLeft
        elif findRight != None:
            return findRight
        else:
            return None
    
    def findBoth(self, root, p, q):
        if root == None:
            return None
        if root.val == p.val:
            return root
        if root.val == q.val:
            return root
        findLeft = self.findBoth(root.left, p, q)
        findRight = self.findBoth(root.right, p, q)
        if findLeft != None and findRight != None:
            return root
        elif findLeft != None:
            return findLeft
        elif findRight != None:
            return findRight
        else:
            return None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        res = self.findBoth(root, p, q)
        if res == p:
            if self.findOne(res.right, q) != None or self.findOne(res.left, q) != None:
                return res
            else:
                return None
        if res == q:
            if self.findOne(res.right, p) != None or self.findOne(res.left, p) != None:
                return res
            else:
                return None
        return res