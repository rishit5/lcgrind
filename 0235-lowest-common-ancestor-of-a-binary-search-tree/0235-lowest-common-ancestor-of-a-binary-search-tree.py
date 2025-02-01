# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def find(self, root, small, large):
        if root.val == small.val or root.val == large.val:
            return root
        if root.val >= small.val and root.val <= large.val:
            return root
        elif root.val < small.val:
            return self.find(root.right, small, large)
        else:
            return self.find(root.left, small, large)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        small = p
        large = q
        if p.val > q.val:
            small = q
            large = p
        return self.find(root, small, large)