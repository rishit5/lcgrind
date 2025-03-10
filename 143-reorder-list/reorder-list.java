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
    public void reorderList(ListNode head) {

        // Find the middle of the node
        ListNode slow = head; 
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the node starting at slow
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        return;

    }
}