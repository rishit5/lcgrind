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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode headNext = head.next;
        ListNode result = head;
        while (headNext != null) {
            for (int i = Math.min(head.val, headNext.val); i >= 1; i--) {
                if (head.val % i == 0 && headNext.val % i == 0) {
                    head.next = new ListNode(i, headNext);
                    break;
                }
            }
            head = headNext;
            headNext = headNext.next;
        }
        return result;
    }
}