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
    public ListNode middleNode(ListNode head) {
        ListNode firstHead = head;
        ListNode secondHead = head;
        
        while (secondHead != null && secondHead.next != null) {
            firstHead = firstHead.next;
            
            secondHead = secondHead.next;
            if (secondHead != null) {
                secondHead = secondHead.next;
            }
        }
        
        return firstHead;
    }
}