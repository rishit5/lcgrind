class Solution(object):
    def findCenter(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: int
        """
        edgecount = {}
        for edge in edges:
            if edge[0] not in edgecount.keys():
                edgecount[edge[0]] = 1
            else:
                edgecount[edge[0]] = edgecount[edge[0]] + 1
            if edge[1] not in edgecount.keys():
                edgecount[edge[1]] = 1
            else:
                edgecount[edge[1]] = edgecount[edge[1]] + 1
            if edgecount[edge[0]] >= 2:
                return edge[0]
            if edgecount[edge[1]] >= 2:
                return edge[1]
        return 0
        