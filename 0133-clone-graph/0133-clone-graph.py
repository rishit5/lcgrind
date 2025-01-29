"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def __init__(self):
        self.dict_ = {}

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None

        if node in self.dict_:
            return self.dict_[node]
        
        cloneNode = Node(node.val, [])

        self.dict_[node] = cloneNode

        for n in node.neighbors:
            cloneNode.neighbors.append(self.cloneGraph(n))
        
        return cloneNode
