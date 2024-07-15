# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import numpy as np

class Solution:
    def build(self, rootVal, nodes):
        if rootVal == -1:
            return None
        if rootVal not in nodes:
            return TreeNode(rootVal)
        return TreeNode(rootVal, self.build(nodes[rootVal][0], nodes), self.build(nodes[rootVal][1], nodes))
        
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        childrens = set(np.array(descriptions)[:,1])
        allNodes = set(np.array(descriptions)[:,0])
        rootVal = list(allNodes.union(childrens).difference(childrens))[0]
        nodes = {}
        for description in descriptions:
            if description[0] not in nodes:
                nodes[description[0]] = [-1, -1]
            if description[2] == 1:
                nodes[description[0]] = [description[1], nodes[description[0]][1]]
            else:
                nodes[description[0]] = [nodes[description[0]][0], description[1]]
        # currNode = treeNode
        print(f"Nodes are {nodes}")
        print(f"RootVal is {rootVal}")
        return self.build(rootVal, nodes)