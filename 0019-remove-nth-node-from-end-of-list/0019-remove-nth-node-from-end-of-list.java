/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer_head = new ListNode(0);
        pointer_head.next = head;
        
        ListNode first = pointer_head;
        ListNode second = pointer_head;
        
        for (int i = 0; i < n; i++) {
            second = second.next;
        }
        
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        
        first.next = first.next.next;
        
        return pointer_head.next;
        
    }
}