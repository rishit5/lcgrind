# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        list_ = []
        list_.append(root)
        list_.append(None)
        init = 0
        while len(list_) > 0:
            curr = list_.pop(0)
            if curr == None:
                if len(list_) > 0 and list_[0] == None:
                    list_.pop(0)
                    break
                else:
                    list_.append(None)
                init += 1
            else:
                if init % 2 == 1:
                    list_1 = [curr]
                    list_.append(curr.right)
                    list_.append(curr.left)
                    while list_[0] != None:
                        nowCurr = list_.pop(0)
                        list_1.append(nowCurr)
                        list_.append(nowCurr.right)
                        list_.append(nowCurr.left)
                    for i,n in enumerate(list_1[:(len(list_1)//2)]):
                        temp = list_1[i].val
                        list_1[i].val = list_1[len(list_1) - i - 1].val
                        list_1[len(list_1) - i - 1].val = temp
                else:
                    list_.append(curr.right)
                    list_.append(curr.left)
        return root
                