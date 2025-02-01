# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def helper(self, root, p, q):
        if root is None:
            return None
        if root.val == p.val:
            return root
        if root.val == q.val:
            return root
        resultRight = self.helper(root.left, p, q)
        resultLeft = self.helper(root.right, p, q)
        if resultRight != None and resultLeft != None:
            return root
        else:
            if resultRight != None:
                return resultRight
            else:
                return resultLeft
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.helper(root, p, q)