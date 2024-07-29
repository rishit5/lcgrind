class Solution(object):
    def minimumCost(self, source, target, original, changed, cost):
        """
        :type source: str
        :type target: str
        :type original: List[str]
        :type changed: List[str]
        :type cost: List[int]
        :rtype: int
        """
        def dijkstra(src, adj):
            heap = [(0, src)]
            min_map = {}
            
            while heap:
                cost, dest = heapq.heappop(heap)
                if dest in min_map:
                    continue
                min_map[dest] = cost
                for nei, nei_cost in adj[dest]:
                    heapq.heappush(heap, (cost + nei_cost, nei))
            return min_map
            
        adj = defaultdict(list)
        for src, dest, cost in zip(original, changed, cost):
            adj[src].append((dest, cost))
        
        min_maps = {src:dijkstra(src, adj) for src in set(source)}
        res = 0
        for src, dest in zip(source, target):
            if dest not in min_maps[src]:
                return -1
            else:
                res += min_maps[src][dest]
        return res