class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        seen_set = set()
        unseen_set = set()
        for a in arr:
            if a in seen_set:
                continue
            if a in unseen_set:
                unseen_set.remove(a)
                seen_set.add(a)
            else:
                unseen_set.add(a)
        i = 0
        for a in arr:
            if a in unseen_set:
                i += 1
            if i == k:
                return a
        return ""
            
        