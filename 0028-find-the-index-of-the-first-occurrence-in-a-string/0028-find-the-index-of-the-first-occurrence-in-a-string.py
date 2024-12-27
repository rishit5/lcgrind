class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        haystack_list = list(haystack)
        needle_list = list(needle)
        for i in range(len(haystack_list)):
            needle_start = 0
            copy_i = i
            if haystack_list[copy_i] == needle_list[needle_start]:
                while copy_i < len(haystack_list) and needle_start < len(needle_list) and haystack_list[copy_i] == needle_list[needle_start]:
                    copy_i += 1
                    needle_start += 1
                if needle_start == len(needle_list):
                    return i
        return -1