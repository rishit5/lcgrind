class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        set_allowed = set(list(allowed))
        count = 0
        for word in words:
            if set(list(word)).difference(set_allowed) == set():
                count += 1
        return count