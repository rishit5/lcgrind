class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        dict_ = [0] * 26
        for i in list(s):
            dict_[ord(i) - 97] += 1
        list_ = []
        for i, n in enumerate(dict_):
            if n == 0:
                continue
            list_.append((-(i+1), n))
        result = ""
        heapq.heapify(list_)
        while len(list_) > 0:
            # print(list_)
            thisChar, count = heapq.heappop(list_)
            takenCount = min(repeatLimit, count)
            count -= takenCount
            result += str(chr(97 + abs(thisChar) - 1) * takenCount)
            if count == 0:
                continue
            else:
                if len(list_) > 0:
                    newChar, newCount = heapq.heappop(list_)
                    result += str(chr(97 + abs(newChar) - 1))
                    newCount -= 1
                    if newCount == 0:
                        # if len(list_) == 0:
                        heapq.heappush(list_, (thisChar, count))
                    else:
                        heapq.heappush(list_, (newChar, newCount))
                        heapq.heappush(list_, (thisChar, count))
                else:
                    break        
        return result