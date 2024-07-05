# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def add_node(self, result, sum_so_far):
        head = result
        if result == None:
            return ListNode(sum_so_far)
        while head.next != None:
            head = head.next
        head.next = ListNode(sum_so_far)
        return result

    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pointer_head = head.next;
        curr_head = head
        sum_so_far = 0
        result = None
        last_ = None
        while pointer_head.val != 0 or pointer_head.next != None:
            if pointer_head.val == 0:
                if result == None:
                    result =  ListNode(sum_so_far)
                    last_ = result
                else:
                    last_.next = ListNode(sum_so_far)
                    last_ = last_.next
                sum_so_far = 0
                pointer_head = pointer_head.next
            else:
                sum_so_far += pointer_head.val
                pointer_head = pointer_head.next
        if last_ == None:
            return ListNode(sum_so_far)
        else:
            last_.next = ListNode(sum_so_far)
            last_ = last_.next
        return result
            
        