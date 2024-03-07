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
        int firstMove = 1;
        int secondMove = 1;
        
        ListNode firstHead = head;
        ListNode secondHead = head;
        
        while (secondHead != null && secondHead.next != null) {
            firstHead = firstHead.next;
            firstMove++;
            
            secondHead = secondHead.next;
            secondMove++;
            if (secondHead != null) {
                secondHead = secondHead.next;
                secondMove++;
            }
        }
        
        return firstHead;
    }
}