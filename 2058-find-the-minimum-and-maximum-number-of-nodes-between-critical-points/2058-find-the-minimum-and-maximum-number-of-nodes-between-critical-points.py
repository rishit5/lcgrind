# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        pointer_head = head;
        back_head = None;
        next_head = pointer_head.next;
        points = set()
        len_ = 0
        while (pointer_head != None):
            if back_head == None or next_head == None:
                back_head = pointer_head
                pointer_head = pointer_head.next
                if next_head != None:
                    next_head = next_head.next
            else:
                if back_head.val < pointer_head.val and next_head.val < pointer_head.val:
                    points.add(len_)
                elif back_head.val > pointer_head.val and next_head.val > pointer_head.val:
                    points.add(len_)
                back_head = pointer_head
                pointer_head = pointer_head.next
                next_head = next_head.next
            len_ += 1;
        points_ = list(points)
        points_.sort()
        min_ = 9999999
        for i, n in enumerate(points_):
            if i == len(points_) -1:
                continue
            else:
                min_ = min(points_[i+1] - points_[i], min_)
        if len(points_) < 2:
            return [-1, -1]
        return [min_, points_[-1] - points_[0]]
        